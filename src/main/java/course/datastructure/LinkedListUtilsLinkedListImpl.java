package course.datastructure;

import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtilsLinkedListImpl implements LinkedListUtils {

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
    for (int i = 0; i < list.size(); i++) {
      String greaterElement = list.get(indexOfElementGreater);
      if (greaterElement.compareTo(list.get(i)) < 0) {
        indexOfElementGreater = i;
      }
    }
    return indexOfElementGreater;
  }

  public boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
    boolean isIn = false;
    int startPosition = 0;
    while ((one.size() - startPosition) >= two.size() && !isIn) {
      for (int i = 0; i < two.size(); i++) {
        if (one.get(startPosition + i) == two.get(i)) {
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
