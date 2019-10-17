
package course.datastructure.sentiment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

  public static final String WORDS_DELIMITERS = " \t\n\r\f,.:;?![]'";

  /*
   * Implement this method in Part 1
   */
  public static List<Sentence> readFile(String filename) {
    List<Sentence> sentences = new ArrayList<>();
    try {
      Path filePath = Paths.get(filename);
      Files.readAllLines(filePath).forEach(line -> {
        addLineToSentenceList(sentences, line);
      });
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    return sentences; // this line is here only so this code will compile if you don't modify it
  }

  private static void addLineToSentenceList(List<Sentence> sentences, String line) {
    String[] words = line.split(" ");
    if (words.length > 0) {
      try {
        Integer sentenceValue = getSentenceValue(words[0]);
        String text = getSentenceText(words);
        sentences.add(new Sentence(sentenceValue, text));
      } catch (NumberFormatException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private static Integer getSentenceValue(String word) {
    Integer sentenceValue = Integer.valueOf(word);
    if (Math.abs(sentenceValue) > 2) {
      throw new NumberFormatException("Value is not inside range allowed values(-2,2): " + sentenceValue);
    }
    return sentenceValue;
  }

  private static String getSentenceText(String[] words) {
    return Arrays.stream(words).skip(1).collect(Collectors.joining(" "));
  }

  /*
   * Implement this method in Part 2
   */
  public static Set<Word> allWords(List<Sentence> sentences) {
    HashMap wordMap = new HashMap();
    for (Sentence sentence : sentences) {
      StringTokenizer tokenizer = new StringTokenizer(sentence.text, WORDS_DELIMITERS, true);
      String lastElement = "";
      while (tokenizer.hasMoreElements()) {
        String text = tokenizer.nextToken().toLowerCase();
        if (!lastElement.equals("'") && !WORDS_DELIMITERS.contains(text)) {
          Word word = wordMap.get(text) != null ? (Word) wordMap.remove(text) : new Word(text);
          word.increaseTotal(sentence.score);
          wordMap.put(text, word);
        } else if (tokenizer.hasMoreElements() && lastElement.equals("'")) {
          text = tokenizer.nextElement().toString();
        }
        lastElement = text;
      }
    }

    return new HashSet<>(wordMap.values());
  }

  /*
   * Implement this method in Part 3
   */
  public static Map<String, Double> calculateScores(Set<Word> words) {

    HashMap<String, Double> wordScores = new HashMap<>();
    words.stream().filter(word -> Optional.ofNullable(word).isPresent()).forEach(word ->
        wordScores.put(word.text, getAverageScore(word))
    );

    return wordScores; // this line is here only so this code will compile if you don't modify it
  }

  private static double getAverageScore(Word word) {
    return Double.valueOf(word.total) / Double.valueOf(word.count);
  }

  /*
   * Implement this method in Part 4
   */
  public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

    /* IMPLEMENT THIS METHOD! */

    return 0; // this line is here only so this code will compile if you don't modify it
  }

  /*
   * This method is here to help you run your program. Y
   * You may modify it as needed.
   */
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Please specify the name of the input file");
      System.exit(0);
    }
    String filename = args[0];
    System.out.print("Please enter a sentence: ");
    Scanner in = new Scanner(System.in);
    String sentence = in.nextLine();
    in.close();
    List<Sentence> sentences = Analyzer.readFile(filename);
    Set<Word> words = Analyzer.allWords(sentences);
    Map<String, Double> wordScores = Analyzer.calculateScores(words);
    double score = Analyzer.calculateSentenceScore(wordScores, sentence);
    System.out.println("The sentiment score is " + score);
  }
}
