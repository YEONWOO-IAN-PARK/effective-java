## 아이템2. 생성자에 매개변수가 많다면 빌더를 고려하라
### 계층형 빌더(Hierarchical Builder)

- 계층형 빌더 사용하기
  - 추상 빌더를 생성하여 제네릭으로 자신의 하위 클래스 타입을 받도록 하는 재귀적인 타입 제한을 사용한다.
  
```java
  public abstract class Pizza {
      public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
      final Set<Topping> toppings;
  
      // 자기 자신을 상속받는 Builder를 사용한다.
      abstract static class Builder<T extends Builder<T>> {
          EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
          public T addTopping(Topping topping) {
              toppings.add(Objects.requireNonNull(topping));
              return self();
  //            return this;  // 자기 자신을 리턴하게 된다면 리턴타입이 Pizza.Builder이므로 서브클래스(NyPizza.Builder)를 사용할 때 마다 형변환이 필요하다.
          }
  
          abstract Pizza build();
  
          // 하위 클래스는 이 메서드를 재정의(overriding)하여
          // "this"를 반환하도록 해야 한다.
          protected abstract T self();
      }
      
      Pizza(Builder<?> builder) {
          toppings = builder.toppings.clone(); // 아이템 50 참조
      }
  }
  ```