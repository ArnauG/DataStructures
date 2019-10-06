package course.datastructure;

import java.util.LinkedList;

public interface LinkedListUtils {

  default public void insertSorted(LinkedList<Integer> list, int value) {
    int additionIndex = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) > value) {
        break;
      }
      additionIndex++;
    }

    list.add(additionIndex, value);
  }

  void removeMaximumValues(LinkedList<String> list, int N);

  boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two);
}
