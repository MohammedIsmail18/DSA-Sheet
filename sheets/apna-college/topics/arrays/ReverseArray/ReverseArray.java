package ReverseArray;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        /*
        Brute Force
        Time Complexity = O(n) - one loop visits every element
        Space Complexity = O(n) - new array stores n no of elements

        int[] arr = {2, 3, 4, 6, 7, 9};
        
        int n = arr.length;

        int[] rev = new int[n];

        for(int i = 0; i<n; i++){

            rev[i] = arr[n-1-i];

        }

        System.out.println("Reversed Array "+ Arrays.toString(rev));
        */

        /* Optimal solution */
        int[] arr = {1, 2, 3, 4, 5};
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.println("Reverse array "+Arrays.toString(arr));
        /*
        Time Complexity - O(n) - 
         */
    }
    
}
