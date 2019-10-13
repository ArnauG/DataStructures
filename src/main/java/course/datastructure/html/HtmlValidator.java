package course.datastructure.html;

import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

  public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
    Stack<HtmlTag> tagsStack = new Stack<>();

    while (tags.size() > 0) {
      HtmlTag tag = tags.remove();
      if (tag.isOpenTag()) {
        tagsStack.push(tag);
      } else if (tagsStack.size() > 0) {
        HtmlTag elementBefore = tagsStack.peek();
        if (!elementBefore.matches(tag)) {
          break;
        }
        tagsStack.pop();
      } else {
        return null;
      }
    }

    return tagsStack;
  }
}

