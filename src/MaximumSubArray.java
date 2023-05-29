/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]<br>
 * Output: 6<br>
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.<br>
 * <a href="https://leetcode.com/problems/maximum-subarray/">LeetCode</a>
 */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            prev = Math.max(prev, prev + nums[i]);
            max = Math.max(max, prev);
        }
        return max;
    }
}
