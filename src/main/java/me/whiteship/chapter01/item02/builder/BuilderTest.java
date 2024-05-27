package me.whiteship.chapter01.item02.builder;

public class BuilderTest {

    public static void main(String[] args) {
        new NutritionFacts.Builder(10, 2)
                .calories(10)
                .build();
    }
}
