package com.aclockwiseorange.ita;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class c2s3p7 {

    private boolean isExist(int[] array, int target) {
        return false;
    }

    @Test
    public void test() {
        int[] array = new Random().ints(100, 1, 1000).toArray();
        int randomIndex1 = new Random().nextInt(100);
        int randomIndex2 = new Random().nextInt(100);
        assertTrue(isExist(array, array[randomIndex1]+array[randomIndex2]));
    }
}
