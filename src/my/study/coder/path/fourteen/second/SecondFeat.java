package my.study.coder.path.fourteen.second;

import static java.lang.System.*;

public class SecondFeat {
    public static void main(String[] args) {
        Vec2 one = new Vec2(1, 1);
        Vec2 two = new Vec2(3, 6);
        Vec2 three = new Vec2(-10, 10);
        Vec2 four = new Vec2(-11, 10);
        Vec2 five = new Vec2(-1, 11);

        out.println("--- SUM of the vectors: ---");
        out.println("ONE and TWO: " + one.sum(two));
        out.println("ONE and THREE: " + one.sum(three));
        out.println("ONE and FOUR: " + one.sum(four));
        out.println("ONE and FIVE: " + one.sum(five));
        out.println("--- SUB of the vectors: ---");
        out.println("ONE and TWO: " + one.sub(two));
        out.println("ONE and THREE: " + one.sub(three));
        out.println("ONE and FOUR: " + one.sub(four));
        out.println("ONE and FIVE: " + one.sub(five));
    }
}
