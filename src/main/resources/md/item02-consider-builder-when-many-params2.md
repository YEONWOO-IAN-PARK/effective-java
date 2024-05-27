## 아이템2. 생성자에 매개변수가 많다면 빌더를 고려하라
### 빌더(Builder)
- 권장하는 방법 : 빌더 패턴
  - 플루언트 API 또는 메서드 체이닝을 한다.
  - 계층적으로 설계된 클래스와 함께 사용하기 좋다.
  - 점층적으로 생성자보다 클라이언트 코드를 읽고 쓰기가 훨씬 간결하고, 자바빈즈보다 훨씬 안전하다.

- 빌더 패턴(Builder Pattern)
  - 사용 시 주의점
    - 모든 클래스에 빌더 패턴을 적용하지 말아야 한다.
  - 사용 조건
    - 클래스에 필수 필드와 비필수 필드가 있을 때, 생성자의 매개변수가 많이 늘어나는 경우(또는 매개변수별 생성자함수가 많아질 경우)
    - 객체를 Immutable 하게 만들고 싶은 경우

  - 더 간단하게 빌더 패턴을 사용할 수 있는 방법 -> 롬복(Lombok)의 @Builder 어노테이션을 사용한다.
    - @Builder를 사용하면 생성자 파라미터에 모든 필드가 들어간 생성자가 자동으로 생성된다.
    - 위의 경우를 허용하고 싶지 않을 경우 @AllArgsConstructor(access = AccessLevel.PRIVATE)
    - 롬복을 사용할 때, 필수 생성자 파라미터를 지정하는 방법은 현재까지는 없다.(2024)


```java
//@Builder <- 이 어노테이션 기본적으로 빌더명을 '클래스명 + Builder' 로 명명된다.
//@Builder(builderClassName = "CustomBuilder") <- 이와 같이 특정 이름으로 빌더클래스명을 변경할 수도 있다.
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NutritionFacts {
    // 필수 필드
    private final int servingSize;
    private final int servings;
    
    // 비필수 필드
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static void main(String[] args) {
        // 아래와 같이 ...x().y().z() 처럼 흘러가듯이 연계된 방법을 플루언트 또는 체이닝이라고 부른다
        NutritionFacts cocaCola = new NutritionFactsBuilder()
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

    }

    public static class Builder {
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 - 기본값으로 초기화한다.
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        // 필수필드를 포함한 생성자 메서드
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
  
```

  
