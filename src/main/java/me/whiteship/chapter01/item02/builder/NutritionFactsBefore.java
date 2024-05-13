package me.whiteship.chapter01.item02.builder;

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

    // 추가옵션 생성자
    // 추가옵션 필드를 받을 경우 생성자 메서드가 비필수 필드 수많큼 많아진다.
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
