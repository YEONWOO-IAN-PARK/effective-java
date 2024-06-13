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
  - 답변3) 컴파일 시점에 IOException, SQLException과 같이 외부 자원에 대한 예외가 발생했을 때 일어나게 되는데 해당 예외 처리를 통해 후처리를 할 수 있다.

  
- 과제1) 자바의 모든 RuntimeException 클래스 이름 한번씩 읽어보기
  물론입니다. 다음은 숫자가 매겨진 목록입니다:
  
  1. **ArithmeticException** : 잘못된 산술 연산이 수행될 때 발생한다. 예를 들어 분모가 0일 때 발생한다.
  2. **ArrayIndexOutOfBoundsException** : 배열의 인덱스가 범위를 벗어날 때 발생한다.
  3. ArrayStoreException : 배열에 잘못된 타입의 객체를 저장하려 할 때 발생한다.
  4. **ClassCastException** : 객체를 특정 클래스의 형식으로 캐스팅 할 때 실패하면 발생한다.
  5. **IllegalArgumentException** : 메서드에 잘못된 인자를 전달할 때 발생한다.
  6. IllegalMonitorStateException : 스레드가 모니터를 잘못 사용할 때 발생한다. 예를 들어, 현재 스레드가 소유하지 않은 모니터를 해제하려 할 때 발생한다.
  7. **IllegalStateException** : 메서드를 호출할 때 객체의 상태가 적절하지 않으면 발생한다.
  8. IllegalThreadStateException : 스레드가 잘못된 상태에서 작업을 시도할 때 발생한다.
  9. **IndexOutOfBoundsException** : 컬렉션, 문자열 또는 배열의 인덱스가 범위를 벗어날 때 발생한다.
  10. NegativeArraySizeException : 음수 크기의 배열을 생성할 때 발생한다.
  11. **NullPointerException** : 참조 변수가 null일 때, 객체의 멤버에 접근하려 할 때 발생한다.
  12. **NumberFormatException** : 문자열을 숫자로 변환할 때 적절하지 않은 형식의 문자열을 제공할 때 발생한다.
  13. SecurityException : 보안 관리자에 의해 허용되지 않는 작업을 시도할 때 발생한다.
  14. **UnsupportedOperationException** : 메서드가 지원되지 않는 연산을 시도할 때 발생한다.
  15. **ConcurrentModificationException** : 컬렉션이 구조적으로 수정되는 동안 컬렉션의 요소를 반복하려고 할 때 발생한다.
  16. EmptyStackException : 스택이 비어 있을 때 팝 또는 피크 작업을 시도할 때 발생한다.
  17. MissingResourceException : 지정된 리소스가 리소스 번들에서 발견되지 않을 때 발생한다.
  18. AnnotationTypeMismatchException : 애노테이션의 요소 타입이 잘못된 경우 발생한다.
  19. BufferOverflowException : 버퍼의 용량을 초과하여 데이터를 추가하려 할 때 발생한다.
  20. BufferUnderflowException : 버퍼의 데이터가 부족한데 데이터를 읽으려 할 때 발생한다.
  21. CannotRedoException : 작업을 다시 수행할 수 없을 때 발생한다.
  22. CannotUndoException : 작업을 되돌릴 수 없을 때 발생한다.
  23. CompletionException : 비동기 작업 중 예외가 발생했을 때 발생한다.
  24. DataBindingException : 데이터 바인딩 중 예외가 발생했을 때 발생한다.
  25. DateTimeException : 날짜/시간 처리 중 예외가 발생했을 때 발생한다.
  26. EnumConstantNotPresentException : 열거형 상수가 존재하지 않을 때 발생한다.
  27. FileSystemAlreadyExistsException : 파일 시스템이 이미 존재할 때 발생한다.
  28. IllformedLocaleException : 잘못된 형식의 로케일을 사용할 때 발생한다.
  29. IncompleteAnnotationException : 애노테이션의 일부 요소가 누락되었을 때 발생한다.
  30. InvalidPathException : 경로 문자열이 잘못되었을 때 발생한다.
  31. MalformedParameterizedTypeException : 매개변수가 잘못된 제네릭 타입을 사용할 때 발생한다.
  32. MirroredTypesException : 주석 처리된 원시 타입이 미러링되어 발생한다.
  33. MissingFormatArgumentException : 포맷 문자열에 필요한 인자가 누락되었을 때 발생한다.
  34. MissingFormatWidthException : 포맷 문자열의 너비가 누락되었을 때 발생한다.
  35. NoSuchElementException : 요청된 요소가 존재하지 않을 때 발생한다.
  36. NoSuchMechanismException : 요청된 메커니즘이 존재하지 않을 때 발생한다.
  37. PatternSyntaxException : 정규 표현식의 구문이 잘못되었을 때 발생한다.
  38. ProviderException : 보안 공급자와 관련된 예외가 발생했을 때 발생한다.
  39. RejectedExecutionException : 작업이 실행 관리자에 의해 거부될 때 발생한다.
  40. TypeNotPresentException : 요청된 타입이 존재하지 않을 때 발생한다.
  41. UncheckedIOException : 입출력 예외를 체크되지 않은 예외로 변환할 때 발생한다.
  42. UndeclaredThrowableException : 선언되지 않은 예외가 던져졌을 때 발생한다.
  43. UnknownFormatConversionException : 포맷 문자열에서 알 수 없는 변환 문자가 있을 때 발생한다.
  44. UnknownFormatFlagsException : 포맷 문자열에서 알 수 없는 플래그가 있을 때 발생한다.
  45. UnsupportedTemporalTypeException : 날짜/시간 타입이 지원되지 않을 때 발생한다.
  46. WrongMethodTypeException : 메서드 타입이 잘못되었을 때 발생한다.


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