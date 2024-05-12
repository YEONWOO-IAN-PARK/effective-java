package me.whiteship.chapter01.item01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListQuiz {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList();
        numbers.add(100);
        numbers.add(20);
        numbers.add(44);
        numbers.add(3);

        System.out.println(numbers);

        Comparator<Integer> desc = (o1, o2) -> o2 - o1;

        numbers.sort(desc.reversed());

        System.out.println(numbers);

        // 내가 구현해본 내림차순, 오름차순 정렬
        List<Integer> numberList =  new ArrayList<>();
        numberList.add(384);
        numberList.add(0);
        numberList.add(132);
        numberList.add(3);

        // 1. 내림차순 정렬
        Comparator<Integer> reverseOrderComp = Comparator.reverseOrder();
        List<Integer> orderedList = numberList.stream().sorted(reverseOrderComp).collect(Collectors.toList());
        System.out.println(orderedList);

        // 1의 내림차순 Comparator를 사용해 오름차순 정렬
        Comparator<Integer> ascendingOrderComp = reverseOrderComp.reversed();
        List<Integer> ascendingList = numberList.stream().sorted(ascendingOrderComp).collect(Collectors.toList());
        System.out.println(ascendingList);
    }
}
