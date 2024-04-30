package me.whiteship.chapter01.item01;

//import me.whiteship.hello.ChineseHelloService;

import me.whiteship.hello.ChineseHelloService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.ServiceLoader;

public class HelloServiceFactory {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        /*
        * 4. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다. (인터페이스 기반 프레임워크, 인터페이스의 정적 메서드)
        * (명시적으로 구체적인 구현체를 import 하지 않음)
        */
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
        Optional<HelloService> helloServiceOptional = loader.findFirst();
        helloServiceOptional.ifPresent(h -> {
            System.out.println(h.hello());
        });

        /*
        * 이 코드블럭은 어떤 구현체를 사용할 것인지 명시적으로 import 해야한다. (특정 구체적인 클래스에 의존적이다)
        */
        HelloService helloService = new ChineseHelloService();
        System.out.println(helloService.hello());

//        Class<?> aClass = Class.forName("me.whiteship.hello.ChineseHelloService");
//        Constructor<?> constructor = aClass.getConstructor();
//        HelloService helloService = (HelloService) constructor.newInstance();
//        System.out.println(helloService.hello());
    }
}

/**
 * ServiceLoader : 자바가 기본으로 제공하는 정적 팩토리 메소드
 * - load(Class<S> s) : 특정 타입의 서비스를 불러온다.
 *  - load() 결과로 받아온 loader 객체는 Iterable을 상속받았다. 즉, 현재 참조할 수 있는 클래스패스 내의 HelloService의 구현체들을 모두 다 가져온다.
 */