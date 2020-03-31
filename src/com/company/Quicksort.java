package com.company;

public class Quicksort extends Sorter {

    private static void median(int[] array, int left, int right) {
        int mid = (right+left)/2;

        if(array[left] <= array[mid] && array[mid] <= array[right]) {
            swap(array, mid, right);
        } else if(array[mid] <= array[left] && array[left] <= array[right]) {
            swap(array, left, right);
        } else if(array[right] <= array[mid] && array[mid] <= array[left]) {
            swap(array, mid, right);
        } else if(array[right] <= array[left] && array[left] <= array[mid]) {
            swap(array, left, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        median(array, left, right);
        int pivot = array[right];
        int i = left-1;
        for(int j = left; j < right; j++) {
            if(array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, right, i+1);
        return i+1;
    }

    public static void sort(int[] array, int left, int right) {
        if(left < right) {
            int split = partition(array, left, right);
            sort(array, left, split-1);
            sort(array, split+1, right);
        }
    }
}


