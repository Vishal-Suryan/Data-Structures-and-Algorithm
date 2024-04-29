import java.util.*;
class Solution {
    public int[] separateDigits(int[] nums) {
      ArrayList<Integer> allDigits = new ArrayList<>();
      for (int num : nums) {
        ArrayList<Integer> numDigits = new ArrayList<>();
        while (num > 0) {
          int rem = num % 10;
          num /= 10;
          numDigits.add(rem);
        }
        Collections.reverse(numDigits);
        allDigits.addAll(numDigits);
      }
      int[] answerArray = new int[allDigits.size()];
      for (int i = 0; i < answerArray.length; i++) {
        answerArray[i] = allDigits.get(i);
      }
      return answerArray;
    }
  }
  