package my.study.coder.path.fourteen.second;

import java.util.StringJoiner;

public class Vec2 {

    private static final int MAX_VALUE = 10;

    private int x, y;

    public Vec2(int x, int y) {
        if (isInRange(x) && isInRange(y)) {
            this.x = x;
            this.y = y;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (isInRange(x)) {
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (isInRange(y)) {
            this.y = y;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vec2.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .toString();
    }

    public Vec2 sum(Vec2 v) {
        int aSum = this.x + v.getX();
        int bSum = this.y + v.getY();
        return new Vec2(aSum, bSum);
    }

    public Vec2 sub(Vec2 v) {
        int xSum = this.x - v.getX();
        int ySum = this.y - v.getY();
        return new Vec2(xSum, ySum);
    }

    private boolean isInRange(int number) {
        return number >= -MAX_VALUE && number <= MAX_VALUE;
    }
}
