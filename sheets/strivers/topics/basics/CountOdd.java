package sheets.strivers.topics.basics;

public class CountOdd {
    
    public static int countOdd(int[] arr){
        int n = arr.length;
        int count = 0;
        for(int i = 0; i<n; i++){
            int num = arr[i];
            if(num%2 != 0){
                count++;
            }
        }

        return count;

    }


    public static void main(String[] args){
        int[] arr = {2, 3, 4, 5, 6};

        int count = 0;
        count = countOdd(arr);
        System.out.println("Odd number count is "+count);
    }
}
