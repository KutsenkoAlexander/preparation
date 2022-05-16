package my.study.coder.path.sixteen.first;

import static java.lang.System.out;

public class FirstFeat {
    public static void main(String[] args) {
        ShopItem shopItemOne = new ShopItem("ItemOne",1,1,1,1,1,1);
        ShopItem shopItemTwo = new ShopItem("ItemTwo",2,2,2,2,2,2);

        out.println("Number of the items: " + ShopItem.getNumberOfItem());
        out.println(shopItemOne);
        out.println(shopItemTwo);
    }
}
