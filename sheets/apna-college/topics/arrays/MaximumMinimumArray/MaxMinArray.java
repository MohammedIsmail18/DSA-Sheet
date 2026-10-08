package MaximumMinimumArray;

import java.util.Arrays;

public class MaxMinArray {

    public static void main(String[] args) {
        /*
            Brute Force approach
         */

        /* 
        int[] arr = {2, 3, 8, 5, 7};
        int max = 0;
        int min = 0;

        Arrays.sort(arr);

        max = arr[arr.length-1];
        min = arr[0];

        System.out.println("Maximum element of an array is "+ max);
        System.out.println("Minimum element of an array is "+min);
        */

        /*
        Optimal approach
        */

        int[] arr = {2, 3, 8, 5, 7};
        int min = arr[0];
        int max = arr[0];

        for(int i = 0; i<arr.length; i++){
            if(arr[i]<min){
                min = arr[i];
            }else if(arr[i]>max){
                max = arr[i];
            }
        }

         System.out.println("Maximum element of an array is "+ max);
        System.out.println("Minimum element of an array is "+min);



    }

}
