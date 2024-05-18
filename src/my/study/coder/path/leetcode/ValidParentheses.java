package my.study.coder.path.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParentheses {
  public static void main(String[] args) {
    out.println(isValid(")("));
    out.println(isValid("{}()[]"));
    out.println(isValid("[])"));
    out.println(isValid("(])"));
    out.println("---------------");
    out.println(isValid2(")("));
    out.println(isValid2("{}()[]"));
    out.println(isValid2("[])"));
    out.println(isValid2("(])"));
    out.println(isValid2("([{}])"));
    out.println(isValid2("([]{}){()[]}"));
  }

  private static boolean isValid(String s) {
    List<Character> stack = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == '(') {
        stack.add(0, c);
      } else if (c == ')') {
        if (!stack.isEmpty()) {
          char result = stack.get(0);
          if (result == '(') {
            stack.remove(0);
          } else {
            stack.add(0, c);
          }
        } else {
          stack.add(0, c);
        }
      } else if (c == '[') {
        stack.add(0, c);
      } else if (c == ']') {
        if (!stack.isEmpty()) {
          char result = stack.get(0);
          if (result == '[') {
            stack.remove(0);
          } else {
            stack.add(0, c);
          }
        } else {
          stack.add(0, c);
        }
      } else if (c == '{') {
        stack.add(0, c);
      } else if (c == '}') {
        if (!stack.isEmpty()) {
          char result = stack.get(0);
          if (result == '{') {
            stack.remove(0);
          } else {
            stack.add(0, c);
          }
        } else {
          stack.add(0, c);
        }
      } else {
        stack.add(0, c);
      }
    }

    return stack.isEmpty();
  }

  private static boolean isValid2(String s) {
    Map<Character, Character> brackets = new HashMap<>();
    brackets.put(')', '(');
    brackets.put(']', '[');
    brackets.put('}', '{');

    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (brackets.containsKey(c)) {
        char top = stack.isEmpty() ? '*' : stack.pop();
        if (top != brackets.get(c)) {
          return false;
        }
      } else {
        stack.push(c);
      }
    }

    return stack.isEmpty();
  }
}
