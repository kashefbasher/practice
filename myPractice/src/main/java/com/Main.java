package com;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static Integer[] convertIntArrayToIntegerArray(int[] intArray) {
        Integer[] integerArray = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            integerArray[i] = Integer.valueOf(intArray[i]);
        }
        return integerArray;
    }
    static int mostFreqEle(int[] arr) {
        Integer[] b = convertIntArrayToIntegerArray(arr);
        Map<Integer, Long> map = Stream.of(b).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Integer k=0;
        Long v=0l;
        for(Integer k1 : map.keySet()) {
            Long v1 = map.get(k1);
            if(v1>v) {
                v=v1;
                k=k1;
            }
        }
        return  map.get(k).intValue();
    }

    public static void main(String[] args) {
        int[] arr = { 40, 50, 30, 40, 50, 30, 30 };
        System.out.println(mostFreqEle(arr));
    }

}