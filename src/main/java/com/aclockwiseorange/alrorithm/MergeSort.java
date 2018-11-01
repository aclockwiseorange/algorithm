package com.aclockwiseorange.alrorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSort {
    public static void sort(int[] array, int start, int end) {
       if (start < end) {
            int middle = Math.floorDiv(start+end, 2);
            sort(array, start, middle);
            sort(array, middle+1, end);
            merge(array, start, middle, end);
        }
    }

    private static void merge(int[] array, int start, int middle, int end) {
        int i = 0;
        int j = 0;
        int[] left = Arrays.copyOfRange(array, start, middle+1);//from is inclusive, end is exclusive
        int[] right = Arrays.copyOfRange(array, middle+1, end+1);
        for(int k=start; k<=end; k++) {
            if (i > left.length-1) {//already end of left
                array[k] = right[j++];
            } else if (j > right.length-1) {//already end of right
                array[k] = left[i++];
            } else if (left[i] < right[j]) {
                array[k] = left[i++];
            } else {
                array[k] = right[j++];
            }
        }
    }

    @Test
    public void test() {
        int[] array = new Random().ints(5, 1, 10).toArray();
        int[] a = Arrays.copyOfRange(array, 0, 0);
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        MergeSort.sort(array, 0, array.length-1);
        assertArrayEquals(sortedArray, array);
    }
}


