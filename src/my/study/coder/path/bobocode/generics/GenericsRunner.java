package my.study.coder.path.bobocode.generics;

public class GenericsRunner {

  public static void main(String[] args) {
    EntityContainer<BaseEntity> baseEntityEntityContainer = new EntityContainer<>();
    baseEntityEntityContainer.setEntity(new BaseEntity());
    System.out.println(baseEntityEntityContainer.getEntity());
  }

}
