/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.<br>
 * You have the following three operations permitted on a word:<br>
 * <ul>
 *     <li>Insert a character</li>
 *     <li>Delete a character</li>
 *     <li>Replace a character</li>
 * </ul>
 * Example 1:<br>
 * Input: word1 = "horse", word2 = "ros"<br>
 * Output: 3<br>
 * Explanation: <br>
 * horse -> rorse (replace 'h' with 'r')<br>
 * rorse -> rose (remove 'r')<br>
 * rose -> ros (remove 'e')<br>
 * <br>
 * Example 2:<br>
 * Input: word1 = "intention", word2 = "execution"<br>
 * Output: 5<br>
 * Explanation: <br>
 * intention -> inention (remove 't')<br>
 * inention -> enention (replace 'i' with 'e')<br>
 * enention -> exention (replace 'n' with 'x')<br>
 * exention -> exection (replace 'n' with 'c')<br>
 * exection -> execution (insert 'u')<br>
 * <a href="https://leetcode.com/problems/edit-distance/">LeetCode</a>
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++)
            dp[i][0] = dp[i - 1][0] + 1;
        for (int i = 1; i <= word2.length(); i++)
            dp[0][i] = dp[0][i - 1] + 1;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
