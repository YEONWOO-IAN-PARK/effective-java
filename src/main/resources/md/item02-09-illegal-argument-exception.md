## 완벽 공략 9. IllegalArgumentException
### 잘못된 인자를 넘겨 받았을 때, 사용할 수 있는 기본 런타임 예외
  
- 질문1) checked exception과 unchecked exception의 차이?
  - 답변1) checked exception은 컴파일 시점에서 검사되고, unchecked exception은 런타임에 발생한다. (자세한 답변은 아래)
  
- 질문2) 간혹 메서드 선언부에 unchecked exception을 선언하는 이유는?
  - 답변2) 개발자가에게 어떤 예외가 발생하는지 명시적으로 선언함으로서 코드 가독성 및 유지보수성이 향상, 코드 안정성 기여, 디버깅 및 로깅이 쉽게 해준다.

```java
public void someMethod() throws NullPointerException, IllegalArgumentException {
    
}

```
  
- 질문3) checked exception은 왜 사용할까?
  - 
  

  
- 과제1) 자바의 모든 RuntimeException 클래스 이름 한번씩 읽어보기
- 과제2) 링크의 글 꼭 읽기

  
---
  

### Checked Exception과 Unchecked Exception
  
- Checked Exception
  1. **컴파일 시점에 검사** : 컴파일러는 이러한 예외가 처리되었는지 확인하고, 예외가 처리되지 않으면 컴파일 에러가 발생한다.
  2. **예외 처리 필요** : try-catch 블록을 사용하거나 메서드 선언부에 throws 키워드를 사용하여 호출자에게 예외를 전달해야 한다.
  3. **주로 외부 자원 사용시 발생** : 파일 입출력, 데이터베이스 접근, 네트워크 통신 등 외부 자원을 사용할 때 자주 발생한다.

```java
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionTest {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("secret_file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

  
- Unchecked Exception
  1. **런타임 시점에 발생** : 프로그램 실행 중에 발생하며, 컴파일러는 이러한 예외를 검사하지 않는다.
  2. **선택적 예외 처리** : 예외 처리가 선택적이며, 예외 처리를 강제하지 않는다. 필요에 따라 예외를 처리하거나 무시할 수 있다.
  3. **주로 프로그래밍 오류로 발생** : NullPointerException, ArrayIndexOutOfBoundsException 등 프로그래밍 오류로 인해 발생하는 경우가 많다.
  
```java
public class UncheckedExceptionTest {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        System.out.println(numbers[5]); // ArrayIndexOutOfBoundsException 발생
    }
}
```