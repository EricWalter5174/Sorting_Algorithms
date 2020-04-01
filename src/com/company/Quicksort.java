package com.company;

public class Quicksort extends Sorter {

    private static void median(int[] array, int left, int right) {
        //initialize the "helper integer" mid by dividing left most and right most bound by 2
        int mid = (right+left)/2;
        //case 1: mid is the median, with left as left bound and right as right bound
        if(array[left] <= array[mid] && array[mid] <= array[right]) {
            swap(array, mid, right);
        }
        //case 2: left is the median, with mid as left bound and right as right bound
        else if(array[mid] <= array[left] && array[left] <= array[right]) {
            swap(array, left, right);
        }
        //case 3: mid is the median, with right as left bound and left as right bound
        else if(array[right] <= array[mid] && array[mid] <= array[left]) {
            swap(array, mid, right);
        }
        //case 4: left is the median, with right as left bound and mid as right bound
        else if(array[right] <= array[left] && array[left] <= array[mid]) {
            swap(array, left, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        //find the median of 3
        median(array, left, right);
        //set pivot element by initializing it with the rightmost element of the array
        int pivot = array[right];
        //i is initially -1, but does not throw an ArrayIndexOutOfBounds because it will be incremented if it needs to be swapped
        int i = left-1;
        //establish the "scanning" element j, which iterates from left to right
        for(int j = left; j < right; j++) {
            //proceeed the index i and swap array[i] and array[j] if the scanning element as found a value <= pivot
            if(array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        //set the pivot on its determined and sorted position of i+1
        swap(array, right, i+1);
        //this is now the
        return i+1;
    }

    public static void sort(int[] array, int left, int right) {
        //exit criterium, if the partition to be checked is only 2 elements, the whole array ist sorted
        if(left < right) {
            //start the sort by an initial partition int split is in sorted position after method call
            int split = partition(array, left, right);
            //sort the left partition
            sort(array, left, split-1);
            //sort right partition
            sort(array, split+1, right);
        }
    }
}


