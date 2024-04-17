package my.study.coder.path.collection;

public class Map {

  public static void main(String[] args) {
    java.util.Map<Integer, String> map = java.util.Map.of(1, "ONE", 2, "TWO");
    System.out.println(map.get(3)); //null
  }

}
