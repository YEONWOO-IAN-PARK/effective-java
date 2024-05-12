##  Item 1. 생성자 대신 정적 팩터리 메서드를 고려하라

### 장점
1. 이름을 가질 수 있다. (생성할 객체의 목적을 함수명으로써 더 잘 표현할 수 있다.)
2. 동일한 시그니처의 생성자 함수를 두 개 이상 생성 할 수 있다.
3. 호출될 때 마다 인스턴스를 새로 생성하지 않아도 된다. (Boolean.valueOf)
4. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다. (인터페이스 기반 프레임워크, 인터페이스의 정적 메서드)
5. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환 할 수 있다.(EnumSet)
6. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다. (서비스 제공자 프레임워크)

### 단점
1. 상속을 하려면 public이나 protected로 생성해야해서 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다
2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다.

### 정리
- p9, **열거 타입**은 인스턴트가 하나만 만들어짐을 보장한다.(Immutable)
- p9, 같은 객체가 자주 요청되는 상황이라면 **플라이웨이트 패턴**을 사용할 수 있다.
- p10, 자바8 부터는 **인터페이스가 정적 메서드**를 가질 수 없다는 제한이 풀렸기 때문에 인스턴스화 불가 동반 클래스를 둘 이유가 별로 없다.
- p11, **서비스 제공자 프레임워크**를 만드는 근간이 된다.
- p12, 서비스 제공자 인터페이스가 없다면 각 구현체를 인스턴스로 만들 때 **리플렉션**을 사용해야 한다.
- p12, 브릿지 패턴
- p12, 의존 객체 주입 프레임워크

### 공략1. 열거 타입(Enumeration)
- 상수 목록을 담을 수 있는 데이터 타입
- 특정한 변수가 가질 수 있는 값을 제한할 수 있다. **타입 안정성(Type-Safety)**를 보장할 수있다.
- **싱글턴 패턴**을 구현할 때 사용하기도 한다.

- 질문1. 특정 Enum 타입이 가질 수 있는 모든 값을 순회하며 출력하라.
- 질문2. enum은 자바의 클래스처럼 생성자, 메서드, 필드를 가질 수 있는가?
- 질문3. enum의 값은 == 연산자로 동일성을 비교할 수 있는가?

- 과제1.  enum을 key로 사용하는 Map을 정의하시오. 또는 enum을 담고있는 Set을 만들어보시오.

---

질문1 해답 :
  
```java
public class EnumTest {
    public static void main(String[] args) {
        Arrays.stream(OrderStatus.values()).forEach(System.out::println);
    }
}
```
  
질문2 해답 : enum은 필드, 생성자, 메서드를 가질 수 있다.
  
```java
public enum OrderStatus {

    PREPARING(0), SHIPPED(1), DELIVERING(2), DELIVERED(3);

    // enum은 상태 또는 데이터를 저장하는 필드를 가질 수 있다. 이 필드들은 각 상수가 생성될 때 초기화될 수 있다.
    private int number;

    // enum에 생성자를 정의할 수 있으며, 이는 주로 enum 상수가 초기화될 때 내부적으로 사용된다.
    // enum의 생성자는 항상 private 이며, 외부에서 enum 인스턴스를 직접 생성할 수 없고, enum 정의에 포함된 상수를 통해서만 인스턴스가 생성된다.
    OrderStatus(int number) {
        this.number = number;
    }

    public int getStatusValue() {
        return number;
    }
}
```

질문3 해답  : 그렇다. ==으로 enum의 상수끼리 비교를 하게 된다면 객체의 동일성을 비교하게 된다. (같은 메모리 주소를 참조하는지 검사)  
```java
enum Color {
    RED, GREEN, BLUE
}

public class EnumComparison {
    public static void main(String[] args) {
        Color a = Color.RED;
        Color b = Color.RED;
        Color c = Color.BLUE;

        System.out.println(a == b); // true 출력
        System.out.println(a == c); // false 출력
    }
}
```  
질문3 해답2 : 그렇다면 equals()로 비교하게 된다면? -> 재정의를 하지 않는 이상 내부적으로는 == 비교이기 때문에 위와 결과가 같다. 


- 과제1.  enum을 key로 사용하는 Map을 정의하시오. 또는 enum을 담고있는 Set을 만들어보시오.

```java
import java.util.HashMap;

public enum Season {
    SPRING, SUMMER, FALL, WINTER
}

public static void main(String[] args) {
	// enum을 key로 하는 Map 정의하기 (EnumMap 사용X)
	Map<Season, Object> enumMap = new HashMap<>();
	enumMap.put(SPRING, obj1);
	enumMap.put(SUMMER, obj2);
	
	// enum을 담고있는 Set 만들기 (EnumSet 사용X)
	Set<Season> enumSet = new HashSet<>();
	enumSet.add(Season.SPRING);
	enumSet.add(Season.SUMMER);
}
```