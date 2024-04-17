package my.study.coder.path.bobocode.generics;

public class EntityContainer<T extends BaseEntity> {

  private T entity;

  public T getEntity() {
    return entity;
  }

  public void setEntity(T entity) {
    this.entity = entity;
  }
}
