package course.datastructure;

import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtilsArrayImpl implements LinkedListUtils {

  public void removeMaximumValues(LinkedList<String> list, int N) {
    int numOfDeletedElements = 0;
    while (numOfDeletedElements < N) {
      int indexOfGreaterElement = getIndexOfGreaterElement(list);
      list.remove(indexOfGreaterElement);
      numOfDeletedElements++;
    }
  }

  private int getIndexOfGreaterElement(LinkedList<String> list) {
    int indexOfElementGreater = 0;
    String[] array = list.toArray(new String[list.size()]);

    for (int i = 0; i < list.size(); i++) {
      String greaterElement = array[indexOfElementGreater];
      if (greaterElement.compareTo(array[i]) < 0) {
        indexOfElementGreater = i;
      }
    }
    return indexOfElementGreater;
  }

  public boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
    boolean isIn = false;
    int startPosition = 0;
    Integer[] oneArray = one.toArray(new Integer[one.size()]);
    Integer[] twoArray = two.toArray(new Integer[two.size()]);
    while ((oneArray.length - startPosition) >= twoArray.length && !isIn) {
      for (int i = 0; i < twoArray.length; i++) {
        if (oneArray[startPosition + i] == twoArray[i]) {
          isIn = true;
        } else {
          isIn = false;
          break;
        }
      }
      startPosition++;
    }
    return isIn;
  }
}
