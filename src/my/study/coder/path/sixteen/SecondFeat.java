package my.study.coder.path.sixteen;

public class SecondFeat {
    public static void main(String[] args) {
        Rect rect = new Rect(2, 11, 2, 6);

        System.out.println("Width of the rectangle: " + Rect.getWidth(rect));
        System.out.println("Height of the rectangle: " + Rect.getHeight(rect));
    }
}

final class Rect {
    private final double x1, x2, y1, y2;

    public Rect(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public static double getWidth(Rect rect) {
        return rect.x2 - rect.x1;
    }

    public static double getHeight(Rect rect) {
        return rect.y2 - rect.y1;
    }
}
