package course.datastructure.html;

import java.io.IOException;
import java.util.Queue;
import java.util.Stack;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HtmlValidatorTest {

  private static final String ROOT_PATH = "/Users/arnau.guell/Source/personal/DataStructures/src/test/resources";

  @Test
  public void itShouldReturnTheTagOfAnUnicOpenTagHtml() throws IOException {

    Queue<HtmlTag> tagsFromHtmlFile = HtmlReader.getTagsFromHtmlFile(
        ROOT_PATH + "/fixtures/html/UniqueOpenTag.html");
    Stack<HtmlTag> validHtml = HtmlValidator.isValidHtml(tagsFromHtmlFile);
    assertTrue(validHtml.size() == 1);

    HtmlTag expectedTag = new HtmlTag("head", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
  }

  @Test
  public void itShouldReturnNullForAUniqueInvalidClosedTag() throws IOException {

    Queue<HtmlTag> tagsFromHtmlFile = HtmlReader.getTagsFromHtmlFile(
        ROOT_PATH + "/fixtures/html/UniqueInvalidClosedTag.html");
    Stack<HtmlTag> validHtml = HtmlValidator.isValidHtml(tagsFromHtmlFile);
    assertNull(validHtml);
  }

  @Test
  public void itShouldReturnStackWithHeadHtmlTagWhenIncoherentClosedTagIsInTheMiddle() throws IOException {

    Queue<HtmlTag> tagsFromHtmlFile = HtmlReader.getTagsFromHtmlFile(
        ROOT_PATH + "/fixtures/html/IncoherentClosedTagClosedTag.html");
    Stack<HtmlTag> validHtml = HtmlValidator.isValidHtml(tagsFromHtmlFile);
    assertTrue(validHtml.size() == 1);

    HtmlTag expectedTag = new HtmlTag("head", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
  }

  @Test
  public void itShouldReturnExpectedTagStacksForExample1() throws IOException {

    Queue<HtmlTag> tagsFromHtmlFile = HtmlReader.getTagsFromHtmlFile(
        ROOT_PATH + "/fixtures/html/Example1.html");
    Stack<HtmlTag> validHtml = HtmlValidator.isValidHtml(tagsFromHtmlFile);
    assertTrue(validHtml.size() == 4);

    HtmlTag expectedTag = new HtmlTag("b", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
    expectedTag = new HtmlTag("p", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
    expectedTag = new HtmlTag("body", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
    expectedTag = new HtmlTag("html", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
  }

  @Test
  public void itShouldReturnExpectedTagStacksForExample2() throws IOException {

    Queue<HtmlTag> tagsFromHtmlFile = HtmlReader.getTagsFromHtmlFile(
        ROOT_PATH + "/fixtures/html/Example2.html");
    Stack<HtmlTag> validHtml = HtmlValidator.isValidHtml(tagsFromHtmlFile);
    assertTrue(validHtml.size() == 2);
    HtmlTag expectedTag = new HtmlTag("body", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
    expectedTag = new HtmlTag("html", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
  }

  @Test
  public void itShouldReturnExpectedTagStacksForExample3() throws IOException {

    Queue<HtmlTag> tagsFromHtmlFile = HtmlReader.getTagsFromHtmlFile(
        ROOT_PATH + "/fixtures/html/Example3.html");
    Stack<HtmlTag> validHtml = HtmlValidator.isValidHtml(tagsFromHtmlFile);
    assertTrue(validHtml.size() == 3);
    HtmlTag expectedTag = new HtmlTag("b", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
    expectedTag = new HtmlTag("body", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
    expectedTag = new HtmlTag("html", true);
    assertTrue(expectedTag.equals(validHtml.pop()));
  }

  @Test
  public void itShouldReturnNullForExample4() throws IOException {

    Queue<HtmlTag> tagsFromHtmlFile = HtmlReader.getTagsFromHtmlFile(
        ROOT_PATH + "/fixtures/html/Example4.html");
    Stack<HtmlTag> validHtml = HtmlValidator.isValidHtml(tagsFromHtmlFile);
    assertNull(validHtml);
  }
}
