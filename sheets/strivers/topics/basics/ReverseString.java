package sheets.strivers.topics.basics;

import java.util.Arrays;

public class ReverseString {
    /*
    public static String reverse(String word){
        int length = word.length();

        String result = "";

        for(int i = length-1; i>=0; i--){
            result += word.charAt(i);
        }

        return result;

    }

    public static void main(String[] args) {
        String word = "Hello";
        String result = reverse(word);
        System.out.println("Result "+result);
    }
    */

    /*Brute Force
   //time complexity is O(n) because using one loop
   //space complexity is O(n) because creating new array to display the result
   public static String reverse(char[] word){
        int length = word.length;

        char[] result = new char[length];

        for(int i = length-1; i>=0; i--){
          char letter = word[i];
          result[length-1-i] = letter;
        }

        return Arrays.toString(result);

    }

    public static void main(String[] args) {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        String result = reverse(word);
        System.out.println("Result "+result);
    }
    */
   //Optimal Approach
   public static String reverse(char[] word){
        int length = word.length;
        int left = 0;
        int right = length-1;

       while(left < right){
        char swap = word[left];
        word[left] = word[right];
        word[right] = swap;
        left++;
        right--;

       }

        return Arrays.toString(word);

    }

    public static void main(String[] args) {
        char[] word = {'H', 'e', 'l', 'l', 'o'};
        String result = reverse(word);
        System.out.println("Result "+result);
    }
}
