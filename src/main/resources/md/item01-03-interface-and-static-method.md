##  3. 인터페이스와 정적 메서드
(자바 8과 9에서 주요 인터페이스 변화)

- 기본 메서드(default method)와 정적 메서드를 가질 수 있다.
- 기본 메서드
  - 인터페이스에서 메서드 뿐 아니라, 기본적인 구현체까지 제공할 수 있다.
  - 기존의 인터페이스를 구현하는 클래스에서 새로운 기능을 추가할 수 있다.
- 정적 메서드
  - 자바 9부터 private static 메서드도 가질 수 있다.
  - 단, private 필드는 아직도 선언할 수 없다.

- 질문1) 내림차순으로 정렬하는 Comparator를 만들고 List<Integer>를 정렬하시오.
- 질문2) 질문1에서 만든 Comparator를 사용해서 오름차순으로 정렬하라.  

```java
public class ListQuiz {
  public static void main(String[] args) {
  
    // 내가 구현해본 내림차순, 오름차순 정렬
    List<Integer> numberList =  new ArrayList<>();
    numberList.add(384);
    numberList.add(0);
    numberList.add(132);
    numberList.add(3);

    // 1. 내림차순 정렬
    Comparator<Integer> reverseOrderComp = Comparator.reverseOrder();
    List<Integer> orderedList = numberList.stream().sorted(reverseOrderComp).collect(Collectors.toList());
    System.out.println(orderedList);   // [384, 132, 3, 0]


    // 1의 내림차순 Comparator를 사용해 오름차순 정렬
    Comparator<Integer> ascendingOrderComp = reverseOrderComp.reversed();
    List<Integer> ascendingList = numberList.stream().sorted(ascendingOrderComp).collect(Collectors.toList());
    System.out.println(ascendingList);  // [0, 3, 132, 384]
  }
}

```
