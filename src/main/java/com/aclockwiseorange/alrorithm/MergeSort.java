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
        int l = 0;
        int r = 0;
        int k = start;
        int[] left = Arrays.copyOfRange(array, start, middle+1);//from is inclusive, end is exclusive
        int[] right = Arrays.copyOfRange(array, middle+1, end+1);
        while(l<left.length && r<right.length) {
            if (left[l] < right[r]) {
                array[k++] = left[l++];
            } else {
                array[k++] = right[r++];
            }
        }

        while(l<left.length) {
            array[k++] = left[l++];
        }

        while(r<right.length) {
            array[k++] = right[r++];
        }
    }

    @Test
    public void test() {
        for(int i=0; i<TestConstants.LOOP_NUMBER; i++) {
            int[] array = new Random().ints(TestConstants.ARRAY_SIZE, TestConstants.MIN_NUMBER, TestConstants.MAX_NUMBER).toArray();
            int[] sortedArray = Arrays.stream(array).sorted().toArray();
            MergeSort.sort(array, 0, array.length - 1);
            assertArrayEquals(sortedArray, array);
        }
    }
}


