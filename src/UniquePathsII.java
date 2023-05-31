/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.<br>
 * An obstacle and space are marked as 1 or 0 respectively in grid.
 * A path that the robot takes cannot include any square that is an obstacle.<br>
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.<br>
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.<br>
 * Example:<br>
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]<br>
 * Output: 2<br>
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right<br>
 * <a href="https://leetcode.com/problems/unique-paths-ii/">LeetCode</a>
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        if (obstacleGrid.length == 1 && obstacleGrid[0].length == 1) {
            return 1;
        }
        boolean blocked = false;
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1 || blocked) {
                obstacleGrid[i][0] = 0;
                blocked = true;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }
        blocked = false;
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1 || blocked) {
                obstacleGrid[0][i] = 0;
                blocked = true;
            } else {
                obstacleGrid[0][i] = 1;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++)
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
