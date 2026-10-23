package ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateValue {
     public static void main(String[] args) {
        /* Brute Force
        int[] arr = {2, 4, 3, 5, 2, 1};
        int n = arr.length;
        boolean result = false;
        for(int i = 0; i<n; i++){
            int check = arr[i];
            for(int j = i+1; j< arr.length; j++){
                if(check == arr[j]){
                    result = true;
                    break;
                }
            }
        }

        if(result == true){
            System.out.println("Duplicate Values Exists");
        }else{
            System.out.println("Duplicate Values Doesn't Exists");
        }
        */
        /*
        Time complexity is O(n^2) - nested loops
        Space Complexity is O(1) - made changes in the existing value
        without creating any new variable or array
        */

        /*
        Optimal Approach
        Time Complexity - O(n) - only one loop
        Space Complexity - O(n) - set stores all the n values
        */

        int[] arr = {2, 4, 5, 3, 2, 1};
        Set<Integer> set = new HashSet<>();
        boolean result = false;
        for(int num : arr){
            if(set.contains(num)){
                result = true;
                break;
            }

            set.add(num);
        }

        if(result){
            System.out.println("Duplicate Values Exists");
        }else{
            System.out.println("Duplicate Values Doesn't Exists");
        }

    }
}
