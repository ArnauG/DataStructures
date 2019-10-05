package course.datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinkedListUtilsTest {

  @Test
  public void itShouldInsertAnElementWhenListIsEmpty() {
    int givenValue = 3;
    int expectedValue = 3;
    LinkedList<Integer> integerLinkedList = new LinkedList<>();
    LinkedListUtils.insertSorted(integerLinkedList, givenValue);
    assertTrue(expectedValue == integerLinkedList.getFirst());
  }

  @Test
  public void itShouldInsertASecondElementAfterAnExistingOne() {

    Integer[] givenArray = {3};
    LinkedList<Integer> integerLinkedList = new LinkedList(Arrays.asList(givenArray));
    int givenValue2 = 4;
    int expectedValue = 4;
    LinkedListUtils.insertSorted(integerLinkedList, givenValue2);
    assertTrue(expectedValue == integerLinkedList.getLast());
  }

  @Test
  public void itShouldInsertASecondElementBeforeAnExistingOne() {

    Integer[] givenArray = {4};
    LinkedList<Integer> integerLinkedList = new LinkedList(Arrays.asList(givenArray));
    int givenValue2 = 3;
    int expectedValue = 3;
    LinkedListUtils.insertSorted(integerLinkedList, givenValue2);
    assertTrue(expectedValue == integerLinkedList.getFirst());
  }

  @Test
  public void itShouldInsertAThirdElementInTheMiddleOfAnotherTwo() {
    Integer[] givenArray = {3, 5};
    LinkedList<Integer> integerLinkedList = new LinkedList(Arrays.asList(givenArray));
    int givenValue3 = 4;
    int expectedValue = 4;
    LinkedListUtils.insertSorted(integerLinkedList, givenValue3);
    assertTrue(expectedValue == integerLinkedList.get(1));
  }

  @Test
  public void itShouldRemoveNotRemoveAnyElement() {
    String[] givenArray = {"Max", "Pepe"};
    int numOfElementsToDelete = 0;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(givenArray));
    LinkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    assertEquals(expected, stringLinkedList);
  }

  @Test
  public void itShouldRemoveLastElementOfLinkedList() {
    String[] givenArray = {"Max", "Pepe"};
    String[] expectedArray = {"Max"};
    int numOfElementsToDelete = 1;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(expectedArray));
    LinkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    assertEquals(expected, stringLinkedList);
  }

  @Test
  public void itShouldRemoveFirstElementOfLinkedList() {
    String[] givenArray = {"Pepe", "Max"};
    String[] expectedArray = {"Max"};
    int numOfElementsToDelete = 1;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(expectedArray));
    LinkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    assertEquals(expected, stringLinkedList);
  }

  @Test
  public void itShouldRemoveAllElementsOfLinkedList() {
    String[] givenArray = {"Pepe", "Max"};
    String[] expectedArray = {};
    int numOfElementsToDelete = 2;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(expectedArray));
    LinkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    assertEquals(expected, stringLinkedList);
  }

  @Test
  public void itShouldRemoveMaxThreeElementsOfLinkedList() {
    String[] givenArray = {"Pepe", "Max", "Mario", "Astrid", "Gudari", "Xylaz"};
    String[] expectedArray = {"Mario", "Astrid", "Gudari"};
    int numOfElementsToDelete = 3;
    LinkedList<String> stringLinkedList = new LinkedList(Arrays.asList(givenArray));
    LinkedList<String> expected = new LinkedList(Arrays.asList(expectedArray));
    LinkedListUtils.removeMaximumValues(stringLinkedList, numOfElementsToDelete);
    assertEquals(expected, stringLinkedList);
  }
}
