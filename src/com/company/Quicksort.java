package com.company;

public class Quicksort extends Sorter {


    // Quicksort Optimiert Median-of-Three
    private static void medianOfThree(int[] a, int p, int r) {
        if(p < r) {
            int s = partition(a, p, r);
            medianOfThree(a, p, s-1);
            medianOfThree(a, s+1, r);
        }

    }
    private static void median(int[] a, int p, int r) {
        int mitte = (r+p)/2;

        if(a[p] <= a[mitte] && a[mitte] <= a[r]) {
            swap(a, mitte, r);
        } else if(a[mitte] <= a[p] && a[p] <= a[r]) {
            swap(a, p, r);
        } else if(a[r] <= a[mitte] && a[mitte] <= a[p]) {
            swap(a, mitte, r);
        } else if(a[r] <= a[p] && a[p] <= a[mitte]) {
            swap(a, p, r);
        }

    }
    private static int partition(int[] a, int p, int r) {
        median(a, p, r);
        int pivot = a[r];
        int i = p-1;
        for(int j = p; j < r; j++) {
            if(a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, r, i+1);

        return i+1;
    }

    // normale Quicksort
    public static void sort(int[] a, int p, int r) {
        if(p < r) {
            int s = partition(a, p, r);
            sort(a, p, s-1);
            sort(a, s+1, r);
        }

    }

}


