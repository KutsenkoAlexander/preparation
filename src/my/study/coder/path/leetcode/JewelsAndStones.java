package my.study.coder.path.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/jewels-and-stones/description/?page=1&difficulty=EASY">771. Jewels and Stones</a>
 */
public class JewelsAndStones {
    static void main() {
        var jewels = "aA";
        var stones = "aAAbbbb";
        System.out.println("Output: " + numJewelsInStones(jewels, stones));
        jewels = "z";
        stones = "ZZ";
        System.out.println("Output: " + numJewelsInStones(jewels, stones));
    }

    private static int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelChars = new HashSet<>();
        for (Character jwlChr : jewels.toCharArray()) {
            jewelChars.add(jwlChr);
        }
        int count = 0;
        for (Character c : stones.toCharArray()) {
            if (jewelChars.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
