package sheets.strivers.topics.basics;

import java.util.HashMap;

public class SumOfHighestLowest {
    static class FrequencyResult{
        
        int maxFrequency;
        int minFrequency;

        FrequencyResult(int maxFrequency, int minFrequency){
            this.maxFrequency = maxFrequency;
            this.minFrequency = minFrequency;
        }

        int sumFrequency(){
            return maxFrequency+minFrequency;
        }
    }

    public static FrequencyResult getFrequencyResult(int[] arr){
        HashMap<Integer, Integer> freeMap = new HashMap();
        int firstMaxElement = -1;
        int firstMaxFrequency = 0;

        int secondMaxElement = -1;
        int secondMaxFrequency = 0;

        int minElement = Integer.MAX_VALUE;
        int minFrequency = Integer.MAX_VALUE;

        for(int i = 0; i<arr.length; i++){
             if(freeMap.containsKey(arr[i])){
                int value = freeMap.get(arr[i]);
                value+=1;
                freeMap.put(arr[i], value);
            }else{
                freeMap.put(arr[i], 1);
                }
        }

        for(HashMap.Entry<Integer, Integer> entry : freeMap.entrySet()){
             int element = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > firstMaxFrequency) {

                secondMaxFrequency = firstMaxFrequency;
                secondMaxElement = firstMaxElement;

                firstMaxFrequency = frequency;
                firstMaxElement = element;

            } else if (frequency < firstMaxFrequency &&
                       frequency > secondMaxFrequency) {

                secondMaxFrequency = frequency;
                secondMaxElement = element;
            }
             if (frequency < minFrequency){
                minFrequency = frequency;
                minElement = element;
            }
        }

        return new FrequencyResult(firstMaxFrequency, minFrequency);
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 1, 4};
        FrequencyResult result = getFrequencyResult(arr);
        System.out.println("Sum of highest and lowest frequency -> "+result.sumFrequency());

    }
  
}
