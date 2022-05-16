package my.study.coder.path.sixteen.third;

import static java.lang.System.*;

public class ThirdFeat {
    public static void main(String[] args) {
        Singleton one = Singleton.getInstance();
        Singleton two = Singleton.getInstance();

        out.println(one.equals(two));
    }
}

