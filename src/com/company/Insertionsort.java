package com.company;

public class Insertionsort extends Sorter {

    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int j = i;
            while (j > 0 && array[j-1] > element) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = element;
        }
    }
}
