package RotatedSortedArray;

public class RotatedSortedArray {

    public static int search(int[] arr, int target){

        int start = 0;
        int end = arr.length-1;
        int res = -1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(target == arr[mid]){
                return mid;
            }
            //to check if left side is sorted
            if(arr[start]<=arr[mid]){
                //to check if target lies in this sorted part
                if(target>=arr[start] && target<arr[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }//to check if right side is sorted
            else{
                if(target>arr[mid] && target<=arr[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;

        int result = search(arr, target);

        System.out.println("Result "+result);
    }
    
}
