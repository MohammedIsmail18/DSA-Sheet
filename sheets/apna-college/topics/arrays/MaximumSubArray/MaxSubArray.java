package MaximumSubArray;

public class MaxSubArray {
    
    public static void main(String[] args) {
        /*
        Brute Force

        int[] arr = {-2, 3, -1, 6, 9, -5, 4};
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i<arr.length; i++){
            int sum = 0;
            for(int j = i; j<arr.length; j++){
                sum+=arr[j];
                if(sum>maxSum){
                    maxSum = sum;
                }
            }
        }

        System.out.println("Maximum SubArray: "+maxSum);

        Time Complexity - O(n to the power 2) - because of two nested loops
        Space Complexity - O(1) - You only use a fixed number of extra variables: 
        You don't create another array or any data structure that grows with n.

        */
       /* Optimal approach */
       int[] arr = {-5, 3, 1, -2, 4};
       int n = arr.length;

       int currentSum = arr[0];
       int maxSum = arr[0];

       for(int i = 0; i<n; i++){
        currentSum = Math.max(arr[i], currentSum+arr[i]);
        maxSum = Math.max(maxSum, currentSum);
       }

       System.out.println("Maximum SubArray "+maxSum);
    }
}
