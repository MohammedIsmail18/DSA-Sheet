package sheets.strivers.topics.basics;

public class ArraySorted {

    public static boolean isSorted(int[] arr){
        int n = arr.length;
        boolean result = true;
        for(int i = 0; i<n-1; i++){
            int first = arr[i];
            int second = arr[i+1];

            if(first > second){
               result = false;
               break; 
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 2, 5, 7, 4};
        boolean result = isSorted(arr);

        System.out.println("Is Array sorted ? "+ result);

    }
}
