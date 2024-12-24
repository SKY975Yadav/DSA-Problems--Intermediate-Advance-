import java.util.HashMap;
import java.util.Map;

public class MaxFrequentlyElement {
    public static void main(String[] args) {

    }
    /*
    You are given an array nums consisting of positive integers.

Return the total frequencies of elements in nums such that those elements all have the maximum frequency.

The frequency of an element is the number of occurrences of that element in the array.



Example 1:

Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.
     */
    public int maxFrequencyElements(int[] arr) {  // Given element
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Step 1: Populate the HashMap with element frequencies
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the maximum frequency and calculate the result
        int maxFrequency = 0;
        int resultSum = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                resultSum = frequency;
            } else if (frequency == maxFrequency) {
                resultSum += frequency;
            }
        }

        return resultSum;
    }
}
