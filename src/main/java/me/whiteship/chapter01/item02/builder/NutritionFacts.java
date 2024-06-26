package me.whiteship.chapter01.item02.builder;

// 코드 2-3 빌더 패턴 - 점층적 생성자 패턴과 자바빈즈 패턴의 장점만 취했다. (17~18쪽)

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * 모든 클래스에 빌더패턴을 적용하지 말아야 한다. 사용 조건은 아래와 같다.
 *  1. 필수 필드와 비필수 필드가 있을 때 생성자의 매개변수가 많이 늘어나는 경우
 *  2. 객체를 Immutable 하게 만들고 싶은 경우

 *  간단하게 빌더패턴을 사용할 수 있는 방법 -> 롬복을 사용한다..
 *   -> 롬복의 @Builder를 사용하게 되면 생성자에 모든 필드가 들어간 AllArgsConstructor가 자동으로 생성되게 되는데
 *   -> 이러한 경우를 허용하고 싶지 않을 경우 @AllArgsConstructor(access = AccessLevel.PRIVATE)로 설정하면 된다.
 *   -> 롬복을 사용할 때, 필수 생성자 파라미터를 지정하는 방법은 현재까지는 없다.
 */
//@Builder <- 이 어노테이션 기본적으로 빌더명을 '클래스명 + Builder' 로 명명된다.
//@Builder(builderClassName = "CustomBuilder") <- 이와 같이 특정 이름으로 빌더클래스명을 변경할 수도 있다.
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static void main(String[] args) {
        // 아래와 같이 ...x().y().z() 처럼 흘러가듯이 연계된 방법을 플루언트 또는 체이닝이라고 부른다
//        NutritionFacts cocaCola = new NutritionFactsBuilder()   // 필수값은 생성자 파라미터로 입력
        NutritionFacts cocaCola = new Builder(10, 0)   // 필수값은 생성자 파라미터로 입력
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
