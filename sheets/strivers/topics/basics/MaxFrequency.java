package sheets.strivers.topics.basics;

import java.util.HashMap;

public class MaxFrequency {

    /*
    //Brute Force Approach
    //Time Complexity = O(n^2) because of two loops
    //Space Complexity = 

    static class FrequencyResult{
        int maxElement;
        int maxFrequency;

        FrequencyResult(int maxElement, int maxFrequency){
            this.maxElement = maxElement;
            this.maxFrequency = maxFrequency;
        }
    }

    public static FrequencyResult getFrequency(int[] arr){

        boolean[] visited = new boolean[arr.length];
        int maxElement = arr[0];
        int maxFrequency = 0;

        for(int i = 0; i<arr.length; i++){
            if(visited[i]){
                continue;
            }
            int count = 1;
            for(int j = i+1; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    count++;
                    visited[j] = true;
                }
            }

            visited[i] = true;
            if(count>maxFrequency){
                maxFrequency = count;
                maxElement = arr[i];
            }
        }

        return new FrequencyResult(maxElement, maxFrequency);
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 4};

        FrequencyResult result = getFrequency(arr);
        System.out.println("Element -> "+result.maxElement+" and Frequency -> "+result.maxFrequency);

    }
    */

    //Optimal Approach
     static class FrequencyResult{
        int maxElement;
        int maxFrequency;

        FrequencyResult(int maxElement, int maxFrequency){
            this.maxElement = maxElement;
            this.maxFrequency = maxFrequency;
        }
    }

    public static FrequencyResult getFrequency(int[] arr){
        HashMap<Integer, Integer> freeMap = new HashMap<>();
        int maxFrequency = 0;
        int maxElement = arr[0];

        for(int i = 0; i<arr.length; i++){
            if(freeMap.containsKey(arr[i])){
                int value = freeMap.get(arr[i]);
                value+=1;
                freeMap.put(arr[i], value);
            }else{
                freeMap.put(arr[i], 1);
                }
            if(freeMap.get(arr[i])>maxFrequency){
                maxFrequency = freeMap.get(arr[i]);
                maxElement = arr[i];
            }
        }

        return new FrequencyResult(maxElement, maxFrequency);
       
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 4};

        FrequencyResult result = getFrequency(arr);
        System.out.println("Element -> "+result.maxElement+" and Frequency -> "+result.maxFrequency);

    }

}
