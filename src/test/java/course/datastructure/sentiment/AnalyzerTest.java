package course.datastructure.sentiment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnalyzerTest {
  private static final String ROOT_PATH =
      "/Users/arnau.guell/Source/personal/DataStructures/src/test/resources/fixtures/sentiments/";

  @Test
  public void itShouldReadASentence() {
    String fileName = ROOT_PATH + "OneValidSentence.txt";
    List<Sentence> sentences = Analyzer.readFile(fileName);
    assertTrue("Number of sentences", sentences.size() == 1);
    assertTrue("Sentence value", sentences.get(0).score == 1);
    assertTrue("Text", sentences.get(0).text.equals("Pepito grillo."));
  }

  @Test
  public void itShouldNotReadASentenceWithoutScore() {
    String fileName = ROOT_PATH + "OneSentenceWithoutScore.txt";
    List<Sentence> sentences = Analyzer.readFile(fileName);
    assertTrue("Number of sentences", sentences.size() == 0);
  }

  @Test
  public void itShouldNotReadASentenceWithInvalidScore() {
    String fileName = ROOT_PATH + "OnlyThreeValidSentences.txt";
    List<Sentence> sentences = Analyzer.readFile(fileName);
    assertTrue("Number of sentences", sentences.size() == 3);
    assertTrue("Sentence value", sentences.get(0).score == 1);
    assertTrue("Text", sentences.get(0).text.equals("Pepito grillo."));
    assertTrue("Sentence value", sentences.get(1).score == -2);
    assertTrue("Text", sentences.get(1).text.equals("Another one ss."));
    assertTrue("Sentence value", sentences.get(2).score == 2);
    assertTrue("Sentence value", sentences.get(2).text.equals(""));
  }

  @Test
  public void itShouldGetAWordWithItPunctuation() {
    List<Sentence> sentences = new ArrayList<>();
    sentences.add(new Sentence(1, "It"));
    Set<Word> words = Analyzer.allWords(sentences);
    assertTrue(words.size() == 1);
    assertTrue(words.iterator().next().text.equals("it"));
    assertTrue(words.iterator().next().count == 1);
  }

  @Test
  public void itShouldSubstractContractionOfAWord() {
    List<Sentence> sentences = new ArrayList<>();
    sentences.add(new Sentence(1, "It's"));
    Set<Word> words = Analyzer.allWords(sentences);
    assertTrue(words.size() == 1);
    assertTrue(words.iterator().next().text.equals("it"));
    assertTrue(words.iterator().next().count == 1);
  }

  @Test
  public void itShouldPunctuateWordsOfASentence() {
    List<Sentence> sentences = new ArrayList<>();
    sentences.add(new Sentence(1, "It's amazing, isn't it?"));
    Set<Word> words = Analyzer.allWords(sentences);
    assertTrue(words.size() == 3);
    Iterator<Word> iterator = words.iterator();
    Word word = iterator.next();
    assertTrue(word.text.equals("amazing"));
    assertTrue(word.count == 1);
    word = iterator.next();
    assertTrue(word.text.equals("isn"));
    assertTrue(word.count == 1);
    word = iterator.next();
    assertTrue(word.text.equals("it"));
    assertTrue(word.count == 2);
  }

  @Test
  public void itShouldPunctuateWordsOfMultipleSentence() {
    List<Sentence> sentences = new ArrayList<>();
    sentences.add(new Sentence(1, "It's amazing, isn't it?"));
    sentences.add(new Sentence(2, "Awesome, I want it"));
    sentences.add(new Sentence(-1, "It isn't awesome"));
    Set<Word> words = Analyzer.allWords(sentences);
    assertTrue(words.size() == 6);
    Iterator<Word> iterator = words.iterator();
    Word word = iterator.next();
    assertTrue(word.text.equals("amazing"));
    assertTrue(word.count == 1);
    assertTrue(word.total == 1);

    word = iterator.next();
    assertTrue(word.text.equals("awesome"));
    assertTrue(word.count == 2);
    assertTrue(word.total == 1);

    word = iterator.next();
    assertTrue(word.text.equals("isn"));
    assertTrue(word.count == 2);
    assertTrue(word.total == 0);

    word = iterator.next();
    assertTrue(word.text.equals("want"));
    assertTrue(word.count == 1);
    assertTrue(word.total == 2);

    word = iterator.next();
    assertTrue(word.text.equals("i"));
    assertTrue(word.count == 1);
    assertTrue(word.total == 2);

    word = iterator.next();
    assertTrue(word.text.equals("it"));
    assertTrue(word.count == 4);
    assertTrue(word.total == 3);
  }
}
