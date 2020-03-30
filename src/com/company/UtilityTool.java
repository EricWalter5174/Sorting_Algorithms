package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UtilityTool {

    public int getLengthOfFile(File file) throws FileNotFoundException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
    int length = 0;
    try {
        while (reader.readLine() != null) {
            length++;
        }
        reader.close();
    } catch(IOException e){
        e.printStackTrace();
        System.out.println("Line counter encountered a problem :'(");
    }
    return length;

    }
    public static int[]readNumber(String filename) throws FileNotFoundException{
        Scanner lesen = new Scanner(new FileReader(filename));
        ArrayList<Integer> al = new ArrayList<Integer>();

        while(lesen.hasNext()) {
            al.add(lesen.nextInt());
        }
        lesen.close();

        int[] a = new int[al.size()];
        for(int i = 0; i < a.length; i++) {
            a[i] = al.get(i);
        }
        return a;
    }

    public void checkIfSorted(int[] array){
        for(int i = 1; i < array.length; i++){
            if (array[i-1] > array[i]){
                System.out.println("The array is NOT sorted correctly from lowest to highest.");
                break;
            }
        }
    }

    public long getTimeDiff(long start, long end){
        return end - start;
    }
}
