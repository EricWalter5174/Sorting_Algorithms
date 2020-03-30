package com.company;

public class Quicksort extends Sorter {

    private static void median(int[] a, int p, int r) {
        int mid = (r+p)/2;

        if(a[p] <= a[mid] && a[mid] <= a[r]) {
            swap(a, mid, r);
        } else if(a[mid] <= a[p] && a[p] <= a[r]) {
            swap(a, p, r);
        } else if(a[r] <= a[mid] && a[mid] <= a[p]) {
            swap(a, mid, r);
        } else if(a[r] <= a[p] && a[p] <= a[mid]) {
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

    public static void sort(int[] a, int p, int r) {
        if(p < r) {
            int s = partition(a, p, r);
            sort(a, p, s-1);
            sort(a, s+1, r);
        }
    }
}


