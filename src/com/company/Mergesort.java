package com.company;

import java.util.Arrays;

public class Mergesort {

    public static void sort(int[] array, int start, int end) {
        int middle = (start + end) / 2;
        int lengthLeft = end - start;
        if (lengthLeft <= 1) {
            return;
        }
        sort(array, start, middle);
        sort(array, middle, end);
        merge(array, start, middle, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] leftSubArray = Arrays.copyOfRange(array, start, mid);
        int[] rightSubArray = Arrays.copyOfRange(array, mid, end);
        int indexLeft = 0, indexRight = 0;
        for(int i = start; i < end; i++) {
            boolean more_left = indexLeft < leftSubArray.length;
            boolean more_right = indexRight < rightSubArray.length;
            boolean left_smaller = more_left && more_right && leftSubArray[indexLeft] <= rightSubArray[indexRight];
            if (!more_right || left_smaller) {
                array[i] = leftSubArray[indexLeft];
                indexLeft++;
            } else {
                array[i] = rightSubArray[indexRight];
                indexRight++;
            }
        }
    }
}
