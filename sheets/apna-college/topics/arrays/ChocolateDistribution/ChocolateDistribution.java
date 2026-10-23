package ChocolateDistribution;

import java.util.Arrays;

public class ChocolateDistribution {

    public static void main(String[] args) {
        int[] arr = {3, 7, 56, 9, 11, 9, 5, 1, 22};
        int m = 5;
        int result = Integer.MAX_VALUE;
        Arrays.sort(arr);

        for(int i = 0; i<=arr.length-m; i++){
            int min = arr[i];
            int max = arr[i+m-1];

            result = Math.min(result, max-min);
        }

        System.err.println("Minimum value is "+result);
    }
    
}
