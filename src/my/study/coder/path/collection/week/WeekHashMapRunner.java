package my.study.coder.path.collection.week;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeekHashMapRunner {
    public static void main(String[] args) {
//        weekHashMapExample();

        Map<String, String> map = new HashMap<>();
        map.put("null", "1");
        map.put("null", "2");
        map.put("null", "3");
        map.put("null", "4");
        map.put("null", "5");
        map.put("null", "6");
        map.forEach((s, s2) -> System.out.println(s2));
    }

    private static void weekHashMapExample() {
        Map<MyData, String> map = new WeakHashMap<>();
        MyData myData = new MyData("New value");
        map.put(myData, "Information");
        myData = null;
        System.gc();
        for (int i = 0; i < 10000; i++) {
            if (map.isEmpty()) {
                System.out.println("Empty!!!");
                break;
            }
        }
    }
}
