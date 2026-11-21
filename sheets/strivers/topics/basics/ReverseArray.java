package sheets.strivers.topics.basics;

import java.util.Arrays;

public class ReverseArray {

    public static int[] reverse(int[] arr){
        int n = arr.length;
        int[] rev = new int[n];
        for(int i = 0; i<n; i++){
            int num = arr[i];
            rev[n-1-i] = num;
        }

        return rev;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6};
        
        int[] rev = reverse(arr);

        System.out.println("Array Reversed "+Arrays.toString(rev));
    }
}
