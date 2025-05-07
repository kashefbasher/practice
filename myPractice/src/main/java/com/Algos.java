package com;

import java.util.Arrays;

public class Algos {

    void sumNumbers() {

        int num = 51234;
        int sum = 0;

        while(num > 0) {
            sum += num%10;
            num = num/10;
        }
        System.out.println(sum);
    }
    static void sumElements() {

        int sum = 7;
        int array[] = {2, 4, 3, 5, 6, -2, 4, 7, 8, 9};

        for(int i=0; i<array.length; i++) {
            int val = array[i];

            for(int j=1; j<array.length; j++) {
                int val2 = array[j];
                if(val + val2 == sum) {
                    System.out.println(val +"+"+ val2 +"="+  sum);
                }
            }
        }
    }

    static void sortElements() {

        int[] array = {3,7,1,2,0,4,9,8,6,5};

        for (int i=0; i<array.length; i++) {

            for (int j=0; j<array.length-1; j++) {

                if(array[j]>array[j+1]) {
                    int t = array[j+1];
                    array[j+1]=array[j];
                    array[j]=t;
                }
            }
        }

        for(int i=0;i<array.length;i++) {
            System.out.print(array[i]);
        }
    }


    public int lengthOfLIS() {

//        300. Longest Increasing Subsequence.
//        Given an integer array nums, return the length of the longest strictly increasing subsequence.
//        Input: nums = [10,9,2,5,3,7,101,18] Output: 4
//        Input: nums = [0,1,0,3,2,3] Output: 4

        int[] nums = {10,9,2,5,3,7,101,18};
        int[] counts = new int[nums.length];
        Arrays.fill(counts, 1);

        for (int i=1; i<nums.length;++i) {

            for (int j=0; j<i;++j) {

                if(nums[i]>nums[j]) {
                    // counts[i] = (counts[i] > counts[j+1]) ? counts[i] : counts[j]+1;
                    counts[i] = Math.max(counts[i], counts[j]+1);
                }
            }
        }

        return Arrays.stream(counts).max().getAsInt();
    }

    public static void main(String[] args) {

        Algos algos = new Algos();
//        algos.sumNumbers();
//        algos.sumElements();
//        algos.sortElements();
        System.out.print(algos.lengthOfLIS());
    }
}
