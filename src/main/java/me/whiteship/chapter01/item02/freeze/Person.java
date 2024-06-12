package me.whiteship.chapter01.item02.freeze;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;

    private final int birthYear;

    private final List<String> kids;

    public Person(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.kids = new ArrayList<>();
    }

    public static void main(String[] args) {
        Person person = new Person("keesun", 1982);
        System.out.println(person.name);

        // kids 필드같은 레퍼런스 타입의 객체는 그 레퍼런스 자체가 Immutable 한 것이지 객체의 요소들이 Immutable 한 것이 아니다!
        person.kids.add("kid's Element is not Immutable");
        person.kids.clear();

    }
}
