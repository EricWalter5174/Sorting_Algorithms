package com.company;

public class Insertionsort extends Sorter {

    public static void sort(int[] array){
        //iterate over the given array. note that index 0 is already considered sorted
        for (int i = 1; i < array.length; i++) {
            //store the value that is being checked
            int element = array[i];
            //set the "scanning" index as i
            int j = i;
            //sort the left list by comparing the element to every value that comes before it
            while (j > 0 && array[j-1] > element) {
                array[j] = array[j-1];
                j--;
            }
            //set index position j as the element, which is now considered sorted
            array[j] = element;
            //do as long as i has not exhausted itself by reaching array.length (excluded)
        }
    }
}
