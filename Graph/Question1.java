package Graph;

import java.util.*;

public class Question1 {

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

        graph[9].add(new Edge(9, 1, 1));
        graph[9].add(new Edge(9, 5, 1));

        graph[1].add(new Edge(1, 9, 1));
        graph[1].add(new Edge(1, 5, 1));

        graph[2].add(new Edge(2, 5, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[5].add(new Edge(5, 2, 1));
        graph[5].add(new Edge(5, 1, 1));
        graph[5].add(new Edge(5, 9, 1));
    }

    // Q1 - Cycle Detection in Undirected Graph using BFS
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean visit[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                if (isCycleUtil(graph, visit, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] visit, int src) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> parentMap = new HashMap<>();

        q.add(src);
        parentMap.put(src, -1); // Mark src as the root node with no parent
        visit[src] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (Edge e : graph[curr]) {
                int neighbor = e.des;

                if (!visit[neighbor]) {
                    //step1  If not visited, mark and add to queue
                    visit[neighbor] = true;
                    q.add(neighbor);
                    parentMap.put(neighbor, curr); // Track parent
                } else if (parentMap.get(curr) != neighbor) {
                    //  step 2 If visited and not the parent, cycle detected
                    return true;
                }
            }
        }

        return false;
    }

    // q2 find minimun depth

    public static int minDepth(ArrayList<Edge>[] graph, int startNode) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from the source node
        queue.add(startNode);
        visited[startNode] = true;

        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current depth level
            depth++;

            for (int i = 0; i < levelSize; i++) {
                int curr = queue.poll();

                // Check if the current node is a leaf node (has no outgoing edges)
                if (graph[curr].isEmpty()) {
                    return depth;
                }

                // Add all unvisited neighbors to the queue
                for (Edge edge : graph[curr]) {
                    if (!visited[edge.des]) {
                        queue.add(edge.des);
                        visited[edge.des] = true;
                    }
                }
            }
        }
        return -1;
    }

    static class Pair {
        int x, y, tm;

        public Pair(int x, int y, int tm) {
            this.x = x;
            this.y = y;
            this.tm = tm;

        }
    }

    // Q3 minimum time to rot all orange
    public static int rotOrange(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int cntFresh = 0;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        // step1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    visit[i][j] = true;
                } else {
                    visit[i][j] = false;

                }
                if (graph[i][j] == 1) {
                    cntFresh++;
                }
            }
        }
        // step 2
        int dRow[] = { -1, 0, +1, 0 };
        int dCOl[] = { 0, 1, 0, -1 };
        int time = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int r = p.x;
            int c = p.y;
            int t = p.tm;
            time = time > t ? time : t;
            for (int i = 0; i < 4; i++) {
                int newR = r + dRow[i];
                int newC = c + dCOl[i];
                if (newR >= 0 && newR < n && newC >= 0 && newC < m &&
                        !visit[newR][newC] && graph[newR][newC] == 1) {
                    cnt++;
                    q.add(new Pair(newR, newC, t + 1));
                    visit[newR][newC] = true;
                }
            }
        }

        if (cnt != cntFresh) {
            return -1;
        }
        return time;
    }

    static int count;

    // Q4 largest matrix ;
    public static void isDfs(int row, int col, int[][] graph, boolean[][] visit) {
        int[] dRow = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dCol = { -1, 0, 1, -1, 1, -1, 0, 1 };

        visit[row][col] = true;

        for (int i = 0; i < 8; i++) {
            int newR = row + dRow[i]; // Calculate new row
            int newC = col + dCol[i]; // Calculate new column

            if (newR >= 0 && newR < graph.length && newC >= 0 && newC < graph[0].length &&
                    !visit[newR][newC] && graph[newR][newC] == 1) {
                count++;
                isDfs(newR, newC, graph, visit); // Recurse to explore the region
            }
        }
    }

    public static int largestRegion(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        boolean[][] visit = new boolean[n][m];
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visit[i][j]) {
                    count = 1; // Reset count for the new region
                    isDfs(i, j, graph, visit);
                    result = Math.max(result, count); // Update result with the largest region size
                }
            }
        }
        return result;
    }

    static class Wordy {
        String word;
        int ans;

        public Wordy(String word, int ans) {
            this.word = word;
            this.ans = ans;
        }
    }

    public static int wordLadder(String startWord, String endWord, String[] words) {
        HashSet<String> st = new HashSet<>(Arrays.asList(words));

        // If the endWord is not in the set, no transformation is possible
        if (!st.contains(endWord)) {
            return 0;
        }

        st.remove(startWord);

        Queue<Wordy> q = new LinkedList<>();
        q.add(new Wordy(startWord, 1));

        while (!q.isEmpty()) {
            Wordy wd = q.poll();
            String word = wd.word;
            int steps = wd.ans;

            // If the current word matches the endWord, return the step count
            if (word.equals(endWord) == true) {
                return steps;
            }

            // Try replacing each character in the word
            for (int i = 0; i < word.length(); i++) {
                char[] replacedCharArray = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (replacedCharArray[i] == ch) {
                        continue; // Skip if the character remains the same
                    }
                    replacedCharArray[i] = ch;
                    String replaceWord = new String(replacedCharArray);

                    // If the new word exists in the set
                    if (st.contains(replaceWord) == true) {
                        st.remove(replaceWord); // Remove to avoid revisiting
                        q.add(new Wordy(replaceWord, steps + 1));
                    }
                }
            }
        }
        return 0; // Return 0 if no transformation sequence is possible
    }

    public static void main(String[] args) {
        // ArrayList<Edge>[] graph = new ArrayList[10];
        // createGraph(graph, 10);
        // int[][] map = {
        // { 1, 1, 0, 1, 1 },
        // { 0, 1, 1, 1, 1 },
        // { 0, 0, 0, 1, 1 }
        // };

        String startWord = "hit";
        String endWord = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

        System.out.println(wordLadder(startWord, endWord, words));
    }

}
