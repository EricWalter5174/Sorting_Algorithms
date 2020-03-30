package com.company;
import java.io.*;
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
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("Line counter encountered a problem :'(");
        }
        return length;

    }

    public int[] toArray(File file, int elements) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(file));
        int[] array = new int[elements];
        int i = 0;
        while(scanner.hasNextInt()){
            array[i++] = scanner.nextInt();
        }
        return array;
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
