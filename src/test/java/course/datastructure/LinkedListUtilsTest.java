package course.datastructure;

import java.util.LinkedList;
import org.junit.Test;

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
  public void itShouldInsertASecondElementAfterAnExistenOne() {
    int givenValue1 = 3;
    int givenValue2 = 4;
    int expectedValue = 4;
    LinkedList<Integer> integerLinkedList = new LinkedList<>();
    integerLinkedList.add(givenValue1);
    LinkedListUtils.insertSorted(integerLinkedList, givenValue2);
    assertTrue(expectedValue == integerLinkedList.getLast());
  }

  @Test
  public void itShouldInsertAThirdElementInTheMidleOfAnotherTwo() {
    int givenValue1 = 3;
    int givenValue2 =5;
    int givenValue3 = 4;
    int expectedValue = 4;
    LinkedList<Integer> integerLinkedList = new LinkedList<>();
    integerLinkedList.add(givenValue1);
    integerLinkedList.add(givenValue2);
    LinkedListUtils.insertSorted(integerLinkedList, givenValue3);
    assertTrue(expectedValue == integerLinkedList.get(1));
  }
}
