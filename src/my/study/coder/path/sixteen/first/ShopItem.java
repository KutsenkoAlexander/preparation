package my.study.coder.path.sixteen.first;

import java.util.StringJoiner;

final class ShopItem {

    private static int numberOfItems;
    private final int id;
    private final String title;
    private final double weight, height, width, depth, length, price;

    public ShopItem(String title, double weight, double height, double width, double depth, double length, double price) {
        this.id = ++numberOfItems;
        this.title = title;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.length = length;
        this.price = price;
    }

    public static int getNumberOfItem() {
        return numberOfItems;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ShopItem.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("title='" + title + "'")
                .add("weight=" + weight)
                .add("height=" + height)
                .add("width=" + width)
                .add("depth=" + depth)
                .add("length=" + length)
                .add("price=" + price)
                .toString();
    }
}
