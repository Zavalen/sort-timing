/*
Zava
CS2050
Program 4
02/20/2024
 */

import java.io.*;
import java.util.*;
import java.lang.System;

public class Program4 {

    static double timing(double startTime, double endTime) {
        return((endTime - startTime) / 1000000000);
    }

    static int[] bubbleSort(int[] list, int numLines) {
        int temp = 0;

        for (int i = 0; i < numLines; i++) {
            for(int j = 1; j < (numLines - i); j++) {
                if( list[j-1] > list[j]) {
                    temp = list[j-1];
                    list[j-1] = list[j];
                    list[j] = temp;
                }
            }
        }

        return (list);
    }

    static int[] selectionSort(int[] list, int numLines) {

        for (int i = 0; i < numLines - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < numLines; j++){
                if (list[j] < list[index]){
                    index = j;
                }
            }
            int smallerNumber = list[index];
            list[index] = list[i];
            list[i] = smallerNumber;
        }
        return (list);
    }

    static int[] insertionSort(int[] list, int numLines) {

        for (int i = 1; i < numLines; ++i) {
            int index = list[i];
            int j = i - 1;

            while (j >= 0 && list[j] > index) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = index;
        }
        return (list);
    }

    static ArrayList<Integer> arrListSort(ArrayList<Integer> list) {

        Collections.sort(list);
        return (list);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the file name");
        String fileName = scanner.nextLine();
        scanner.close();

        ArrayList<Integer> arrList = new ArrayList<Integer>();
        double startTime, endTime, finalTime;

        try {
            // Assigns the file to an arraylist
            int line = 0;
            File numFile = new File(fileName);
            Scanner myReader = new Scanner(numFile);
            for (int i = 0; myReader.hasNextInt(); i++) {
                arrList.add(myReader.nextInt());
            }
            myReader.close();

            // creates array from arraylist and then copies it
            int numLines = arrList.size();
            int[] list = new int[numLines];
            for(int i = 0; i < numLines; i++) {
                list[i] = arrList.get(i);
            }
            int[] listTwo = list.clone();
            int[] listThree = list.clone();


            // sorting methods
                // bubble sort
            startTime = System.nanoTime();
            bubbleSort(list, numLines);
            endTime = System.nanoTime();
            System.out.println("Bubble Sort of a file of " + numLines + " integers took: " + timing(startTime,endTime) + " seconds.");

                // selection sort
            startTime = System.nanoTime();
            selectionSort(listTwo, numLines);
            endTime = System.nanoTime();
            System.out.println("Selection Sort of a file of " + numLines + " integers took: " + timing(startTime,endTime) + " seconds.");

                // Insertion sort
            startTime = System.nanoTime();
            insertionSort(listThree, numLines);
            endTime = System.nanoTime();
            System.out.println("Insertion Sort of a file of " + numLines + " integers took: " + timing(startTime,endTime) + " seconds.");

                // .sort
            startTime = System.nanoTime();

            endTime = System.nanoTime();
            System.out.println("ArrayList<Integer>.sort of a file of " + arrList.size() + " integers took: " + timing(startTime,endTime) + " seconds.");

        }

        catch (FileNotFoundException e) {
            System.out.println("Unable to find the file correctly :'(");
            e.printStackTrace();

        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The file has changed from the original");
            e.printStackTrace();
        }

    }
}