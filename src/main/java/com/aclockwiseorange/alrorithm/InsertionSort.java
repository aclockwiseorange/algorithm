package com.aclockwiseorange.alrorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSort {

    public static void sort(int[] array) {
        for(int i=1; i<array.length; i++) {
            int inserting = array[i];
            int j = i-1;
            while(j >=0 && inserting < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = inserting;
        }
    }

    @Test
    public void test() {
        int[] arrayA = new int[]{1, 10, 5, 3, 7};
        int[] arrayB = Arrays.copyOf(arrayA, arrayA.length);
        Arrays.sort(arrayB);
        InsertionSort.sort(arrayA);
        assertArrayEquals(arrayB, arrayA);
    }
}
