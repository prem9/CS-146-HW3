package com.example;

//necessary packages

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class quickSortmethod {
    public static void main(String[] args) {

        int[] intoflist = new int[50];
        intoflist = arrayOfInt();
        intoflist = quickSort(intoflist, 0, intoflist.length - 1);
        toString(intoflist);

    }

    // prints array
    public static void toString(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // sorts through quick sort method
    public static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        
        return arr;
    }

    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    // swapping two units in an array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // reads the txt file and creates array of ints
    public static int[] arrayOfInt() {
        int[] listOfints = new int[70];
        Scanner scn = new Scanner(System.in);
        try {
            scn = new Scanner(new File("F:/Github/CS-146-HW3/demo/src/main/java/com/example/MyList-1.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int i = 0;
        while (scn.hasNext()) { // while there is another token to read
            int s = scn.nextInt(); // reads in the String tokens
            listOfints[i] = s;
            i++;
        }

        
        return listOfints;
    }
}
