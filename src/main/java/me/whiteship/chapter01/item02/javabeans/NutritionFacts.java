package me.whiteship.chapter01.item02.javabeans;

// 코드 2-2 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다. (16쪽)
// 자바빈즈 스펙(기준)
// 1. 클래스는 직렬화가 가능해야 한다.
// 2. 클래스는 기본 생성자를 가져야 한다.
// 3. 프로퍼티 접근을 위한 getter, setter를 제공해야 한다.
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
        // 장점 : 자바빈즈를 사용하면 객체생성이 쉬워진다.
        // 단점1 : 자바빈즈를 사용하면 필요한 값의 값세팅 없이 사용될 때 예외를 발생시킬 가능성이 있다.
        // 단점2 : 필요한 값을 어디까지 세팅해야 맞는지 알 수 없다.
        NutritionFacts cocaCola = new NutritionFacts();
        // setter를 사용하면 불변객체로 사용할 수 없다.
        cocaCola.setServingSize(240);
        cocaCola.setServings(8);

        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);
    }
}
