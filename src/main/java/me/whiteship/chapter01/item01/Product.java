package me.whiteship.chapter01.item01;

import java.util.EnumSet;

public class Product {

    public static void main(String[] args) {

        /*
        * Settings의 생성자 함수의 접근제한자가 private 이므로 다른 클래스에서 생성자 함수를 호출 할 수 없음
        */
//        Settings settings = new Settings();

        Settings settings1 = Settings.getInstance();
        Settings settings2 = Settings.getInstance();

        System.out.println(settings1);
        System.out.println(settings2);

        /*
        3. 호출될 때 마다 인스턴스를 새로 생성하지 않아도 된다. (Boolean.valueOf)
        */
        Boolean.valueOf(false);
        EnumSet.allOf(Difficulty.class);
    }
}
