package my.study.coder.path.collection.week;

import java.util.StringJoiner;

public class MyData {
    private final String value;

    public MyData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyData.class.getSimpleName() + "[", "]")
                .add("value='" + value + "'")
                .toString();
    }
}
