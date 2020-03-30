/*
 * Authors: Eric Walter, Giuseppe Buccellato, Niklas Kirschnowski
 * Algorithmen und Datenstrukturen, Prof. Karsten Morisse
 * Sommersemester 2020
*/
package com.company;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main {
static String name;
static long timerStart;
static long timerEnd;
static long temp1, temp2, temp3, temp4;

    public static void main(String[] args) throws FileNotFoundException {
    UtilityTool util = new UtilityTool();
    Scanner input = new Scanner(System.in);

    System.out.println("State ABSOLUTE path to file (e.g.: C:\\Users\\ericw\\IdeaProjects\\Sorting Algorithms\\res\\daten_100k)");

    String path = input.nextLine();
    File file = new File(path);
    int elements = util.getLengthOfFile(file);
    int[] array = util.readNumber(path);
    System.out.println("\n Choose sorting algorithm: \n Insertionsort \t(1) \n Heapsort \t\t(2)\n Quicksort \t\t(3)\n Mergesort \t\t(4)\n Comparison \t(5)");
    int select = input.nextInt();
        switch (select) {
            case 1:
                insertion(array);
                break;
            case 2:
                heap(array);
                break;
            case 3:
                quick(array);
                break;
            case 4:
                merge(array);
                break;
            case 5:
                insertion(array);
                temp1 = timerEnd - timerStart;
                array = util.readNumber(path);
                heap(array);
                temp2 = timerEnd - timerStart;
                array = util.readNumber(path);
                quick(array);
                temp3 = timerEnd - timerStart;
                array = util.readNumber(path);
                merge(array);
                temp4 = timerEnd - timerStart;
        }
        util.checkIfSorted(array);
        if(select < 5) {
            System.out.println("Time to sort an array of " + elements + " Elements using " + name + ": " + (timerEnd - timerStart) + "ms");
        }
        else{
            System.out.println("Insertionsort: " + temp1 + "ms" + "\nHeapsort: \t\t" + temp2 + "ms" + "\nQuicksort: \t\t" + temp3 + "ms" + "\nMergesort: \t\t" + temp4 + "ms");
        }
    }

//SORTING METHODS
    public static void insertion(int[] array){
        timerStart = System.currentTimeMillis();
        Insertionsort.sort(array);
        timerEnd = System.currentTimeMillis();
        name = "Insertionsort";
    }
    public static void heap(int[] array){
        timerStart = System.currentTimeMillis();
        Heapsort.sort(array);
        timerEnd = System.currentTimeMillis();
        name = "Heapsort";
    }
    public static void quick(int[] array){
        timerStart = System.currentTimeMillis();
        Quicksort.sort(array, 0, array.length-1);
        timerEnd = System.currentTimeMillis();
        name = "Quicksort";
    }
    public static void merge(int[] array){
        timerStart = System.currentTimeMillis();
        Mergesort.sort(array, 0, array.length);
        timerEnd = System.currentTimeMillis();
        name = "Mergesort";
    }
}


