package sheets.strivers.topics.basics;

public class ArraySum {

    public static int sumArray(int[] arr){

        int n = arr.length;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum+=arr[i];
        }

        return sum;

    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6};

        int total = sumArray(arr);

        System.out.println("Sum of array is "+total);
        
    }
}
