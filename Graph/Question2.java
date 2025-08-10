package Graph;

import java.util.*;

public class Question2 {

    static class Edge {
        int src;
        int des;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int size) {
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

    }

    // Q1 Find MotheVertix
    public static void dfs(boolean visit[], int src, ArrayList<Edge>[] graph) {
        visit[src] = true;
        for (Edge e : graph[src]) {

            if (!visit[e.des]) {
                dfs(visit, e.des, graph);
            }
        }
    }

    public static int motherVertix(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];
        int mother = 0;
        // find the last visited node
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                dfs(visit, i, graph);
                mother = i;
            }
        }
        // check if mother index is the mother
        visit = new boolean[graph.length];
        dfs(visit, mother, graph);

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                return -1;
            }
        }
        return mother;
    }

    // Q3 find weather to finish all task
    public static boolean isFinishTask(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    indegree[j]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.remove();
            count++;
            for (int i = 0; i < n; i++) {
                if (graph[curr][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        return count == n;
    }

    // !5 closed island
    public static void dfsS(int row, int col, int n, int m, int[][] graph, boolean visit[][], boolean isHasCorner) {
       // base case 
        if (row < 0 || col < 0 || row >= n || col >= m || graph[row][col] == 0 || visit[row][col]) {
            return;
        }
        if (row == 0 || col == 0 || row == n - 1 || col == m - 1) {
            if (graph[row][col] == 1) {
                isHasCorner = true;

            }
        }
        ;
        visit[row][col] = true;
        dfsS(row + 1, col, n, m, graph, visit, isHasCorner);
        dfsS(row - 1, col, n, m, graph, visit, isHasCorner);
        dfsS(row, col + 1, n, m, graph, visit, isHasCorner);
        dfsS(row, col - 1, n, m, graph, visit, isHasCorner);

    }

    public static int numOfClosed(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        boolean visit[][] = new boolean[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean hasCorner = false;
                if (i != 0 && j != 0 && i != n - 1 && j != m - 1 && !visit[i][j] && graph[i][j] == 1) { 
                    dfsS(i, j, n, m, graph, visit, hasCorner);
                    if (!hasCorner) {
                        result++;
                    }
                }
            }
        }
        return result ;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 0, 1 },
                { 0, 1, 0, 1, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1 } };
        System.out.println(numOfClosed(matrix));

    }

}

// Q2 Find Cycle
class FindClycle {
    static int parent[]; // Parent array to store the parent of each vertex
    // Initialize the disjoint set

    public static void init(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Find operation with path compression
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    // Union operation
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    // Q2 Check if there is a cycle in the graph
    public static boolean isCycle(int[][] graph, int n) {
        init(n); // Initialize the disjoint set for n vertices
        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            if (find(u) == find(v)) {
                return true; // Cycle detected
            }
            union(u, v); // Union the two vertices
        }
        return false; // No cycle found
    }

}

// Q4 Alien Dictionary
class AlienDictionary {
    public String findOrder(String[] dict, int k) {
        // Step 1: Create adjacency list and in-degree array
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[k];

        // Step 2: Build the graph
        for (int i = 0; i < dict.length - 1; i++) {
            String w1 = dict[i];
            String w2 = dict[i + 1];
            int len = Math.min(w1.length(), w2.length());

            boolean foundDifference = false;
            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    int u = w1.charAt(j) - 'a';
                    int v = w2.charAt(j) - 'a';
                    adjList.get(u).add(v);
                    indegree[v]++;
                    foundDifference = true;
                    break;
                }
            }

            // Edge case: prefix issue
            if (!foundDifference && w1.length() > w2.length()) {
                return "";
            }
        }

        // Step 3: Topological sort using BFS
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            sb.append((char) (u + 'a'));

            for (int v : adjList.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        // If the result length is not equal to k, a cycle exists
        if (sb.length() != k) {
            return "";
        }

        return sb.toString();
    }
}
