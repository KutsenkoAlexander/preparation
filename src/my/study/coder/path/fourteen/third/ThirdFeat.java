package my.study.coder.path.fourteen.third;

public class ThirdFeat {
    public static void main(String[] args) {
        Lib lib = new Lib();
        lib.add(new Book("A Title", "A Author", 2000, 300));
        lib.add(new Book("B Title", "B Author", 2010, 100));
        lib.add(new Book("C Title", "C Author", 2020, 500));
        lib.printBooks();
        System.out.println("-------------------------------------");
        lib.remove(new Book("B Title", "B Author", 2010, 100));
        lib.printBooks();
    }
}
