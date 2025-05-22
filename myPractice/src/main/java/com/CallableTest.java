package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<Integer> intList = new ArrayList<>(0);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        intList.add(8);
        intList.add(9);
        intList.add(10);

        MyCallable cb1 = new MyCallable(intList,0,intList.size()/2);
        MyCallable cb2 = new MyCallable(intList,5,intList.size());
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> f1 = executorService.submit(cb1);
        Future<Integer> f2 = executorService.submit(cb2);
        Integer c1 = f1.get();
        Integer c2 = f2.get();
        System.out.println("Total = "+ (c1+c2));
    }
}

class MyCallable implements Callable {

    List<Integer> intList;
    int countFrom=0;
    int countTo=0;

    public MyCallable(List<Integer> intList, int countFrom, int countTo) {
        this.intList = intList;
        this.countFrom = countFrom;
        this.countTo=countTo;
    }

    @Override
    public Integer call() {
        Integer count = 0;
        intList = intList.subList(countFrom, countTo);
        System.out.println(intList);
        for(Integer i : intList) {
            count += i;
        }

        System.out.println(" = "+ count);
        return count;
    }
}