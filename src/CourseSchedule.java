import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first
 * if you want to take course ai.<br>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.<br>
 * Return true if you can finish all courses. Otherwise, return false.<br>
 * Example 1:<br>
 * Input: numCourses = 2, prerequisites = [[1,0]]<br>
 * Output: true<br>
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.<br>
 * Example 2:<br>
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]<br>
 * Output: false<br>
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
 * So it is impossible.<br>
 * <a href="https://leetcode.com/problems/course-schedule/">LeetCode</a>
 */
public class CourseSchedule {
    class Node {
        int course = -1;
        List<Node> deps = new ArrayList<>();
        Node(int course) {
            this.course = course;
        }

        boolean nonCircular(boolean[] visited, boolean[] trace) {
            if (trace[course]) {
                return false;
            }
            if (visited[course]) {
                return true;
            }
            visited[course] = true;
            trace[course] = true;
            boolean result = true;
            for (Node dep : deps) {
                result &= dep.nonCircular(visited, trace);
            }
            trace[course] = false;
            return result;
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i=0; i<numCourses; i++) {
            nodes[i] = new Node(i);
        }
        for (int i=0; i<prerequisites.length; i++) {
            nodes[prerequisites[i][0]].deps.add(nodes[prerequisites[i][1]]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] trace = new boolean[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (!nodes[i].nonCircular(visited, trace))
                return false;
        }
        return true;
    }
}
