package com.example;

/**
 * sorting through merge sort
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class mergeSort 
{
    public static void main(String[] args) {

        int[] intoflist = new int[50];
        intoflist = arrayOfInt();
        intoflist = sort(intoflist, 0, intoflist.length - 1);
        toString(intoflist);

    }
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public static int[] sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }
    public static void toString(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
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
            int s = scn.nextInt(); // reads in the String tokens "Hello" "CSstudents"
            listOfints[i] = s;
            i++;
        }

        
        return listOfints;
    }
}
