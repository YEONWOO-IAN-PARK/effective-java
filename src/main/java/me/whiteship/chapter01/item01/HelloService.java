package me.whiteship.chapter01.item01;

// Service Provider Interface (서비스 제공자 인터페이스)
// 구현체는 같은 프로젝트 내, 다른 프로젝트 내에 있어도 상관없다.
public interface HelloService {

    String hello();


    static String hi() {
        prepareMessage();
        return "hi";
    }

    // 자바 9부터 static private 메서드를 인터페이스에서 정의 가능
    static private void prepareMessage() {
    }

    static String hi1() {
        prepareMessage();
        return "hi";
    }

    // 자바 8 : public한 static method를 인터페이스에서 정의 가능
    static String hi2() {
        prepareMessage();
        return "hi";
    }

    // 자바 8부터 default 메서드도 인터페이스에서 정의 가능하다.
    default String bye() {
        return "bye";
    }
}
