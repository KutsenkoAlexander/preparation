package my.study.coder.path.sixteen;

import static java.lang.System.*;

public class ThirdFeat {
    public static void main(String[] args) {
        Singleton one = Singleton.getInstance();
        Singleton two = Singleton.getInstance();

        out.println(one.equals(two));
    }
}

final class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
