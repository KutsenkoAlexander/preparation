package my.study.coder.path.annotation;

import java.util.Arrays;

import static java.lang.System.out;

public class Runner {
    public static void main(String[] args) {
        var annotation = ClassForTest.class.getAnnotation(Marker.class);
        out.println(annotation.value());

        var declaredAnnotation = ClassForTest.class.getDeclaredAnnotation(Marker.class);
        out.println(declaredAnnotation.value());

        var annotations = ClassForTest.class.getDeclaredAnnotations();
        out.println(Arrays.toString(annotations));
    }
}
