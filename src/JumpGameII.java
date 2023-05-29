import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i.<br>
 * In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * <ul>
 * <li>0 <= j <= nums[i]</li>
 * <li>i + j < n</li>
 * </ul>
 * Return the minimum number of jumps to reach nums[n - 1].
 * The test cases are generated such that you can reach nums[n - 1].<br>
 * Input: nums = [2,3,1,1,4]<br>
 * Output: 2<br>
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.<br>
 * <a href="https://leetcode.com/problems/jump-game-ii/">LeetCode</a>
 */
public class JumpGameII {
    public int jump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.add(0);
        int[] stepsCount = new int[nums.length];

        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            if (i == nums.length - 1) {
                return stepsCount[i];
            }
            for (int j = 1; j < nums.length - i && j <= nums[i]; j++) {
                if (!visited[i + j]) {
                    visited[i + j] = true;
                    queue.add(i + j);
                    stepsCount[i + j] = stepsCount[i] + 1;
                }
            }
        }
        return 0;
    }
}
