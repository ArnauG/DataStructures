package course.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public abstract class LinkedListUtilsBaseTest {
  public static final int NUM_OF_NAMES_IN_FIXTURE = 500;
  LinkedListUtils linkedListUtils;

  @Test
  public void itShouldInsertAnElementWhenListIsEmpty() {
    int givenValue = 3;
    int expectedValue = 3;
    LinkedList<Integer> integerLinkedList = new LinkedList<>();
    linkedListUtils.insertSorted(integerLinkedList, givenValue);
    assertTrue(expectedValue == integerLinkedList.getFirst());
  }

  @Test
  public void itShouldInsertASecondElementAfterAnExistingOne() {

    Integer[] givenArray = {3};
    LinkedList<Integer> integerLinkedList = new LinkedList(Arrays.asList(givenArray));
    int givenValue2 = 4;
    int expectedValue = 4;
    linkedListUtils.insertSorted(integerLinkedList, givenValue2);
    assertTrue(expectedValue == integerLinkedList.getLast());
  }

  @Test
  public void itShouldInsertASecondElementBeforeAnExistingOne() {

    Integer[] givenArray = {4};
    LinkedList<Integer> integerLinkedList = new LinkedList(Arrays.asList(givenArray));
    int givenValue2 = 3;
    int expectedValue = 3;
    linkedListUtils.insertSorted(integerLinkedList, givenValue2);
    assertTrue(expectedValue == integerLinkedList.getFirst());
  }

  @Test
  public void itShouldInsertAThirdElementInTheMiddleOfAnotherTwo() {
    Integer[] givenArray = {3, 5};
    LinkedList<Integer> integerLinkedList = new LinkedList(Arrays.asList(givenArray));
    int givenValue3 = 4;
    int expectedValue = 4;
    linkedListUtils.insertSorted(integerLinkedList, givenValue3);
    assertTrue(expectedValue == integerLinkedList.get(1));
  }

  @Test
  public void itShouldRemoveNotRemoveAnyElement() {
    String[] givenArray = {"Max", "Pepe"};
    int numOfElementsToDelete = 0;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(givenArray));
    linkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    assertEquals(expected, stringLinkedList);
  }

  @Test
  public void itShouldRemoveLastElementOfLinkedList() {
    String[] givenArray = {"Max", "Pepe"};
    String[] expectedArray = {"Max"};
    int numOfElementsToDelete = 1;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(expectedArray));
    linkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    assertEquals(expected, stringLinkedList);
  }

  @Test
  public void itShouldRemoveFirstElementOfLinkedList() {
    String[] givenArray = {"Pepe", "Max"};
    String[] expectedArray = {"Max"};
    int numOfElementsToDelete = 1;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(expectedArray));
    linkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    assertEquals(expected, stringLinkedList);
  }

  @Test
  public void itShouldRemoveAllElementsOfLinkedList() {
    String[] givenArray = {"Pepe", "Max"};
    String[] expectedArray = {};
    int numOfElementsToDelete = 2;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(expectedArray));
    linkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    assertEquals(expected, stringLinkedList);
  }

  @Test
  public void itShouldRemoveMaxThreeElementsOfLinkedList() {
    String[] givenArray = {"Pepe", "Max", "Mario", "Astrid", "Gudari", "Xylaz"};
    String[] expectedArray = {"Mario", "Astrid", "Gudari"};
    int numOfElementsToDelete = 3;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(expectedArray));
    linkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    assertEquals(expected, stringLinkedList);
  }

  @Test
  public void itShouldReturnFalseWhenSecondSequenceIsLongerThanFirst() {
    Integer[] givenFirstArray = {3, 5};
    LinkedList<Integer> firstSequence = new LinkedList(Arrays.asList(givenFirstArray));
    Integer[] givenSecondArray = {3, 5, 3};
    LinkedList<Integer> secondSequence = new LinkedList(Arrays.asList(givenSecondArray));

    boolean result = linkedListUtils.containsSubsequence(firstSequence, secondSequence);

    assertFalse(result);
  }

  @Test
  public void itShouldReturnFalseIfASingleELementIsNotContainedInTheSequence() {
    Integer[] givenFirstArray = {3, 5};
    LinkedList<Integer> firstSequence = new LinkedList(Arrays.asList(givenFirstArray));
    Integer[] givenSecondArray = {6};
    LinkedList<Integer> secondSequence = new LinkedList(Arrays.asList(givenSecondArray));

    boolean result = linkedListUtils.containsSubsequence(firstSequence, secondSequence);

    assertFalse(result);
  }

  @Test
  public void itShouldReturnTrueIfASingleELementIsContainedInTheSequence() {
    Integer[] givenFirstArray = {3, 5};
    LinkedList<Integer> firstSequence = new LinkedList(Arrays.asList(givenFirstArray));
    Integer[] givenSecondArray = {5};
    LinkedList<Integer> secondSequence = new LinkedList(Arrays.asList(givenSecondArray));

    boolean result = linkedListUtils.containsSubsequence(firstSequence, secondSequence);

    assertTrue(result);
  }

  @Test
  public void itShouldReturnTrueForSameSequenceIsContainedInTheSequence() {
    Integer[] givenFirstArray = {3, 5};
    LinkedList<Integer> firstSequence = new LinkedList(Arrays.asList(givenFirstArray));
    Integer[] givenSecondArray = {3, 5};
    LinkedList<Integer> secondSequence = new LinkedList(Arrays.asList(givenSecondArray));

    boolean result = linkedListUtils.containsSubsequence(firstSequence, secondSequence);

    assertTrue(result);
  }

  @Test
  public void itShouldReturnTrueForASequenceIsContainedInTheMiddleSequence() {
    Integer[] givenFirstArray = {3, 7, 8, 5};
    LinkedList<Integer> firstSequence = new LinkedList(Arrays.asList(givenFirstArray));
    Integer[] givenSecondArray = {7, 8};
    LinkedList<Integer> secondSequence = new LinkedList(Arrays.asList(givenSecondArray));

    boolean result = linkedListUtils.containsSubsequence(firstSequence, secondSequence);

    assertTrue(result);
  }

  @Test
  public void itShouldReturnFalseForASequenceNotContainedInTheSequence() {
    Integer[] givenFirstArray = {3, 7, 8, 5};
    LinkedList<Integer> firstSequence = new LinkedList(Arrays.asList(givenFirstArray));
    Integer[] givenSecondArray = {7, 9};
    LinkedList<Integer> secondSequence = new LinkedList(Arrays.asList(givenSecondArray));

    boolean result = linkedListUtils.containsSubsequence(firstSequence, secondSequence);

    assertFalse(result);
  }

  @Test
  public void itShouldRemoveAllElementsOfLinkedListHeavyLoad() throws IOException {
    String[] givenArray = loadNames("fixtures/names");
    String[] expectedArray = {};
    int numOfElementsToDelete = NUM_OF_NAMES_IN_FIXTURE;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(expectedArray));
    long start = System.currentTimeMillis();
    linkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    long end = System.currentTimeMillis();
    System.out.println("DEBUG: Logic Test took " + (end - start) + " MilliSeconds");
    assertEquals(expected, stringLinkedList);
  }

  private static String[] loadNames(String path) throws IOException {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    InputStream inputStream = classloader.getResourceAsStream(path);
    ArrayList<String> names = new ArrayList();
    try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {
      String strCurrentLine;

      while ((strCurrentLine = buffer.readLine()) != null) {
        names.add(strCurrentLine);
      }
    }
    return names.toArray(new String[NUM_OF_NAMES_IN_FIXTURE]);
  }
}
