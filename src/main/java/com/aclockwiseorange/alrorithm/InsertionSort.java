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
        int[] array = new int[]{1, 10, 5, 3, 7};
        int[] sortedArray = Arrays.copyOf(array, array.length);
        Arrays.sort(sortedArray);
        InsertionSort.sort(array);
        assertArrayEquals(sortedArray, array);
    }
}
