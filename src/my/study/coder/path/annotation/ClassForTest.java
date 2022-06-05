package my.study.coder.path.annotation;

@Marker
public class ClassForTest implements TestInterface{
    @Override
    public void doSomething() {
        System.out.println("DO something");
    }
}
