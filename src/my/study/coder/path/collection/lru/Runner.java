package my.study.coder.path.collection.lru;

import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        lruCacheExample();
    }

    private static void lruCacheExample() {
        Map<Integer, String> map = new SimpleLruCache<>(2);

        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");

        map.get(2);

        map.put(9, "d");

        map.forEach((integer, str) -> System.out.println(integer));
    }
}
