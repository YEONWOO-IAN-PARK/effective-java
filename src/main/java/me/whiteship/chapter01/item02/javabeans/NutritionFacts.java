package me.whiteship.chapter01.item02.javabeans;

import java.io.Serializable;

// 코드 2-2 자바빈즈 패턴 - 일관성이 깨지고, 불변으로 만들 수 없다. (16쪽)
// 자바빈즈 스펙(기준)
// 1. 클래스는 직렬화가 가능해야 한다.
// 2. 클래스는 기본 생성자를 가져야 한다.
// 3. 프로퍼티 접근을 위한 getter, setter를 제공해야 한다.
public class NutritionFacts implements Serializable {
    // 필드 (기본값이 있다면) 기본값으로 초기화된다.
    private int servingSize  = -1; // 필수; 기본값 없음
    private int servings     = -1; // 필수; 기본값 없음
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;
    private boolean healthy;

    // 자바빈 스펙에서 아무 아규먼트가 없는 기본 생성자를 규약으로 정했을까?
    // 1. 직렬화와 역직렬화 : 기본 생성자가 없으면 역직렬화 시 객체를 인스턴스화 할 방법이 없다.
    // 2. 프레임워크(Spring, Hibernate, ...)와의 호환성 : 리플렉션 사용 시 기본 생성자를 통해 객체를 인스턴스화 한다.
    // 3. Bean의 재사용성과 유연성 : 기본 생성자로 객체 생성 후 setter로 값을 주입한다.
    // 4. 편리한 객체 생성 : 복잡한 매개변수 없이 객체를 생성할 수 있다.
    public NutritionFacts() { }


    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    // 자바빈 스펙에서 boolean 값의 접두사는 get이 아니라 is다
    public boolean isHealthy() {
        return healthy;
    }

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
