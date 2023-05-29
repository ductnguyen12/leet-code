/**
 * You are given a 0-indexed binary string s and two integers minJump and maxJump.
 * In the beginning, you are standing at index 0, which is equal to '0'.
 * You can move from index i to index j if the following conditions are fulfilled:
 * <ul>
 * <li>i + minJump <= j <= min(i + maxJump, s.length - 1)</li>
 * <li>s[j] == '0'</li>
 * </ul>
 * Return true if you can reach index s.length - 1 in s, or false otherwise.<br>
 * Input: s = "011010", minJump = 2, maxJump = 3<br>
 * Output: true<br>
 * Explanation:<br>
 * In the first step, move from index 0 to index 3.<br>
 * In the second step, move from index 3 to index 5.<br>
 * <a href="https://leetcode.com/problems/jump-game-vii/">LeetCode</a>
 */
public class JumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        int left = 0;
        int right = 0;
        int countTrue = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i - minJump >= 0) {
                if (dp[right]) {
                    countTrue++;
                }
                right++;
            }
            if (i - maxJump > 0) {
                if (dp[left]) {
                    countTrue--;
                }
                left++;
            }
            dp[i] = s.charAt(i) == '0' && countTrue > 0;
        }
        return dp[s.length() - 1];
    }
}
