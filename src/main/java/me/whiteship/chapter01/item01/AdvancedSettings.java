package me.whiteship.chapter01.item01;

public class AdvancedSettings {

    /*
    1. 상속을 하려면 public이나 protected로 생성해야해서 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다

        Settings 클래스를 상속할 수 없는 이유?
        -> 정적 팩터리 메서드를 포함하는 클래스는 기본 생성자가 private 이기 때문에 상속을 사용할 수 없다.
        해결책으로는 아래와 같이 위임(delegation)으로 상속을 사용하지 않더라도 Settings의 기능을 사용할 수 있게 된다.
    */
    Settings settings;


}
