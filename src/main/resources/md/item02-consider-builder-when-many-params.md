## 아이템2. 생성자에 매개변수가 많다면 빌더를 고려하라
### 생성자 체이닝과 자바빈즈
- 정적 팩터리와 생성자에 선택적 매개변수가 많을 때 고려할 수 있는 방안
  - 대안1 : 점층적 생성자 패턴 또는 생성자 체이닝 (빌더)
    - 매개변수가 늘어나면 클라이언트 코드를 작성하거나 읽기 어렵다.
  - 대안2 : 자바빈즈 패턴
    - 완전한 객체를 만들려면 메서드를 여러번 호출해야 한다. (일관성이 무너진 상태가 될 수도 있다)
    - 클래스를 불변으로 만들 수 없다.
  

- 생성자에 매개변수가 많을 경우, 또는 매개변수의 종류만큼 생성자 메서드가 많이 존재할 경우
  - 단점
    - 수많은 필드를 매개변수로 전부 받아야 한다.
    - 생성자 메서드의 수가 필드의 경우의 수 만큼 많아 질 수 있다.
  
```java
public class NutritionFactsBefore {

    // 필수 필드
    private final int servingSize;
    private final int servings;

    // 비필수 필드
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    // 기본 생성자
    public NutritionFactsBefore(int servingSize, int servings) {
        this.servingSize = servingSize;
        this.servings = servings;
    }

    // 필수 * 비필수 생성자
    //  메서드가 비필수 필드 수많 큼 많아질 수 있다.
    public NutritionFactsBefore(int servingSize, int servings, int calories) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
    }

    public NutritionFactsBefore(int servingSize, int servings, int calories, int fat) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
    }

    public NutritionFactsBefore(int servingSize, int servings, int calories, int fat, int sodium) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
    }

    public NutritionFactsBefore(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
```
  
- 자바빈즈 패턴
  - 장점
    - 객체 생성을 생성자 메서드의 파라미터 없이 간단하게 할 수 있다.(기본 생성자 메서드 사용)
  - 단점
    - 일관성이 깨질 수 있다. (필요값 세팅이 안된채로 사용될 여지가 있음)
    - 불변객체로 만들 수 없다. (setter의 사용 <- 자바빈즈의 스펙 준수)
    - 기본 생성자만 존재할 경우, 필요한 값의 세팅이 어디까지 이루어져야 하는지 알 수 없다.
  
```java
public class NutritionFacts {
    // 필드 (기본값이 있다면) 기본값으로 초기화된다.
    private int servingSize  = -1; // 필수; 기본값 없음
    private int servings     = -1; // 필수; 기본값 없음
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;
    private boolean healthy;

    public NutritionFacts() { }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts();
        // setter를 사용하면 불변객체로 사용할 수 없다.
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);

        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}
```

### 자바빈즈 스펙이란?
1. 클래스는 직렬화가 가능해야 한다.
2. 클래스는 기본 생성자를 가져야 한다.
3. 프로퍼티 접근을 위한 getter, setter 를 제공해야 한다.

---
  
- 빌더 패턴을 사용함으로서 점층적 생성자 패턴과 자바빈즈의 장점만 취했다.
  - 원하는 필드의 값만 세팅해서 객체를 생성할 수 있음(가독성도 좋음)
  - 불변 객체를 생성할 수 있음(모든 필드가 final이고 필드 값 세팅은 객체 생성시에만 가능)
  - 
```java
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static void main(String[] args) {
        NutritionFacts cocaCola = new Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27).build();
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

        // 필수 필드 빌더
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        // 옵션 필드 빌더
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

        // Builder를 전달받아 객체생성을 하는 메서드
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    // Builder를 넘겨받아 NutritionFacts의 필드에 값을 세팅한다.
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