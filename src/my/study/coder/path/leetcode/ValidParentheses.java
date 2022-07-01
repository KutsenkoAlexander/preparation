package my.study.coder.path.leetcode;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParentheses {
    public static void main(String[] args) {
        out.println(isValid(")("));
        out.println(isValid("{}()[]"));
        out.println(isValid("[])"));
        out.println(isValid("(])"));
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

}
