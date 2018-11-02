package com.aclockwiseorange.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertionSort {

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertingValue = array[i];
            int j = i - 1;
            while (j >= 0 && insertingValue < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = insertingValue;
        }
    }

    @Test
    public void test() {
        for(int i=0; i<TestConstants.LOOP_NUMBER; i++) {
            int[] array = new Random().ints(TestConstants.ARRAY_SIZE, TestConstants.MIN_NUMBER, TestConstants.MAX_NUMBER).toArray();
            int[] sortedArray = Arrays.stream(array).sorted().toArray();
            InsertionSort.sort(array);
            assertArrayEquals(sortedArray, array);
        }
    }
}
