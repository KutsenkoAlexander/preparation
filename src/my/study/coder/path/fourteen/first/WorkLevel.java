package my.study.coder.path.fourteen.first;

import java.util.Arrays;

public enum WorkLevel {

    SUPER_BAD(1),
    BAD(2),
    NORMAL(3),
    GOOD(4),
    SUPER_GOOD(5);
    private final int level;

    WorkLevel(int level) {
        this.level = level;
    }

    public static WorkLevel valueOfLevel(int level) {
        return Arrays.stream(values())
                .filter(workLevel -> workLevel.level == level)
                .findFirst()
                .orElse(null);
    }
}
