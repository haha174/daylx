package middle.green.course_schedule;

import common.TreeNode;

import java.util.*;


//
//class Solution {
//    List<List<Integer>> edges;
//    int[] indeg;
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        edges = new ArrayList<List<Integer>>();
//        for (int i = 0; i < numCourses; ++i) {
//            edges.add(new ArrayList<Integer>());
//        }
//        indeg = new int[numCourses];
//        for (int[] info : prerequisites) {
//            edges.get(info[1]).add(info[0]);
//            ++indeg[info[0]];
//        }
//
//        Queue<Integer> queue = new LinkedList<Integer>();
//        for (int i = 0; i < numCourses; ++i) {
//            if (indeg[i] == 0) {
//                queue.offer(i);
//            }
//        }
//
//        int visited = 0;
//        while (!queue.isEmpty()) {
//            ++visited;
//            int u = queue.poll();
//            for (int v: edges.get(u)) {
//                --indeg[v];
//                if (indeg[v] == 0) {
//                    queue.offer(v);
//                }
//            }
//        }
//
//        return visited == numCourses;
//    }
//
//    public static void main(String[] args) {
//        int[][] data={{1,2},{2,3}};
//        System.out.println(new Solution().canFinish(4,data));
//    }
//}


class Solution {
    List<List<Integer>> edges = new ArrayList<>();
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indeg = new int[numCourses];
        for (int i=0;i<numCourses;i++) {
            edges.add(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            indeg[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int visit=0;
        for (int i=0;i<numCourses;i++){
            if (indeg[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            visit++;
            int u=queue.poll();
            for (Integer c:edges.get(u)){
                indeg[c]--;
                if (indeg[c]==0){
                    queue.offer(c);
                }
            }
        }

        return visit==numCourses;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 2}, {2, 3}};
        System.out.println(new Solution().canFinish(4, data));
    }
}

//
//class Solution {
//    List<List<Integer>> edges;
//    int[] visited;
//    boolean valid = true;
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        edges = new ArrayList<List<Integer>>();
//        for (int i = 0; i < numCourses; ++i) {
//            edges.add(new ArrayList<Integer>());
//        }
//        visited = new int[numCourses];
//        for (int[] info : prerequisites) {
//            edges.get(info[1]).add(info[0]);
//        }
//        for (int i = 0; i < numCourses && valid; ++i) {
//            if (visited[i] == 0) {
//                dfs(i);
//            }
//        }
//        return valid;
//    }
//
//    public void dfs(int u) {
//        visited[u] = 1;
//        for (int v: edges.get(u)) {
//            if (visited[v] == 0) {
//                dfs(v);
//                if (!valid) {
//                    return;
//                }
//            } else if (visited[v] == 1) {
//                valid = false;
//                return;
//            }
//        }
//        visited[u] = 2;
//    }
//
//
//    public static void main(String[] args) {
//        int[][] data={{0,1},{1,2}};
//        System.out.println(new Solution().canFinish(3,data));
//    }
//}
//

