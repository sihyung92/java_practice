package com.practice.util;

import java.util.*;

public class CollectionClassExercise {

    //합집합, 차집합, 교집합 구해보기
    // array1 = [1,2,3,4]
    // array2 = [3,4,5,6]
    public static void main(String[] args) {
        practice1();
        practice2();
    }

    public static void practice1() {
        List<Integer> firstArray = Arrays.asList(new Integer[]{1, 2, 3, 4});
        List<Integer> secondArray = Arrays.asList(new Integer[]{3, 4, 5, 6});
        ArrayList<Integer> kyo = new ArrayList<>(); // 교집합
        ArrayList<Integer> cha = new ArrayList<>(); // 차집합
        ArrayList<Integer> hap = new ArrayList<>(); // 합집합

        kyo.addAll(firstArray);
        kyo.retainAll(secondArray);

        cha.addAll(firstArray);
        cha.removeAll(secondArray);

        hap.addAll(firstArray);
        hap.removeAll(kyo);
        hap.addAll(secondArray);

        System.out.println("list1=" + firstArray);
        System.out.println("list2=" + secondArray);
        System.out.println("kyo=" + kyo);
        System.out.println("cha=" + cha);
        System.out.println("hap=" + hap);
    }

    public static void practice2() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"라자바바", "a", "b"});
        list.add(new String[]{"다자바", "a", "b"});
        list.add(new String[]{"가자바", "a", "b"});
        list.add(new String[]{"나자바", "a", "b"});
        list.add(new String[]{"라자바", "a", "b"});

        sortByName(list, true);
        sortByName(list, false);

        list.stream().map(Arrays::toString).forEach(System.out::println);
    }

    private static void sortByName(List<String[]> list, boolean isAscending) {
        Collections.sort(list, (o1, o2) -> {
            if (!Objects.isNull(o1) && !Objects.isNull(o2)) {
                return o1[0].compareTo(o2[0]) * (isAscending ? -1 : 1);
            }
            return 0;
        });
    }

}

