import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <a href="https://leetcode.com/problems/generate-parentheses/">LeetCode</a>
 */
public class GenerateParentheses {
    String buildResult(List<Integer> openPos) {
        StringBuilder resultBuilder = new StringBuilder(")".repeat(2 * openPos.size()));
        openPos.forEach(pos -> resultBuilder.replace(pos, pos + 1, "("));
        return resultBuilder.toString();
    }

    boolean validResult(String result) {
        int countOpen = 0;
        int countClose = 0;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '(') {
                countOpen += 1;
            } else {
                countClose += 1;
            }
            if (countClose > countOpen) {
                return false;
            }
        }
        return true;
    }

    void acceptResult(List<Integer> openPos, List<String> results) {
        String result = buildResult(openPos);
        if (validResult(result)) {
            results.add(result);
        }
    }

    public void backtrack(int index, int n, int k, int start, List<Integer> list, List<String> results) {
        if (index == k) {
            acceptResult(list, results);
            return;
        }

        for (int i = start; i < n - 1; i++) {
            list.add(i);
            backtrack(index + 1, n, k, i + 1, list, results);
            list.remove(list.size() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        backtrack(0, 2 * n, n, 0, new ArrayList<>(), results);
        return results;
    }
}
