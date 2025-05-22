package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Threads {

    public static void main(String f[]) throws Exception {
        System.out.println( " ");
        new Threads().CompletableFuture();
    }

    public void CompletableFuture() throws ExecutionException, Exception {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
        integerList.add(10);

        List<Integer> integerList1 = integerList.subList(0, integerList.size()/2);
        List<Integer> integerList2 = integerList.subList((integerList.size()/2), integerList.size());

        System.out.println(integerList1);
        System.out.println( integerList2);
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(()-> {
            int count = 0;
            for(int i: integerList1) {
                count += i;
            }
            return count;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(()-> {
            int count = 0;
            for(int i: integerList2) {
                count += i;
            }
            return count;
        });

        List count = Stream.of(future1, future2).map(f -> {

            try {
                return f.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        System.out.println(count);
    }

}
