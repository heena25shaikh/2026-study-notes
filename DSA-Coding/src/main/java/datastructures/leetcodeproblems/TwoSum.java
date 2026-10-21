package datastructures.leetcodeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/***
 *
 * Problem:
 * Find indices of the two numbers in an array that add up to a target.
 *
 * int nums [2,11,5,4]
 * target = 9
 * ===================================================
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 *
 */

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,11,5,4};
        int[] result = findTwoSum(nums, 9);

        System.out.println(Arrays.toString(result));

    }

    public static int [] findTwoSum(int num[], int target) {

        HashMap map = new HashMap<Integer, Integer>();

        for (int i = 0; i < num.length; i++) {
            int complement = target - num[i];  //9-2 = 7

            if(map.containsKey(complement))
            {
                return new int[]{(int) map.get(complement), i};
            }
            map.put(num[i],i);
        }

        return null;
    }

}
