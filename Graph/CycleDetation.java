package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CycleDetation {
    static class Edge {
        int src;
        int des;

        public Edge(int s, int d) {
            this.src = s;
            this.des = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int size) { // O(V+E);indirected
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        // 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        // 3
        // graph[3].add(new Edge(3, 2));
    }

    public static void createGraph2(ArrayList<Edge>[] graph, int size) { // O(V+E);directed
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0
        // graph[0].add(new Edge(0, 2));
        // 1
        // graph[1].add(new Edge(1, 0));

        // 2
        graph[2].add(new Edge(2, 3));

        // 3
        graph[3].add(new Edge(3, 1));
        // 4
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));

        // 5
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    // topic 1 find cycle in unDiracted using DFS
    public static boolean cycleDetect(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (cycleDetectUtil(graph, vis, i, -1)) {
                    return true;
                    // cycle exist in one of the parts ;
                }
            }
        }
        return false;
    }

    public static boolean cycleDetectUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int parent) {
            vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 3
            if (!vis[e.des]) {
                if (cycleDetectUtil(graph, vis, e.des, curr)) {
                    return true;
                }
            }
            // case 1; if my neibour is visited ans he is not my parent
            else if (vis[e.des] && e.des != parent) {
                return true;
            }
        }
        return false;
    }

    // topic 2 find* using Biratite Graph using coloring algorithm ;
    public static boolean bipartiteGrath(ArrayList<Edge>[] graph) {

        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1; // color == 1 meain blue and color == 0 yellow and color == -1 no color asign
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { // BFS
                q.add(i);
                color[i] = 1;

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        // case 1 if no color in neibou
                        if (color[e.des] == -1) {
                            int nextCol = color[curr] == 0 ? 1 : 0;
                            color[e.des] = nextCol;
                            q.add(e.des);
                        } else if (color[e.des] == color[curr]) {
                            return false; // No Bipartite
                        }
                    }
                }

            }
        }

        return true;
    }

    // topic 3 find cycle Directed Graph using Stack method
    public static boolean inCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (inCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean inCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.des]) {
                return true;
            }

            if (!vis[e.des]) {
                if (inCycleUtil(graph, e.des, vis, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    // topic 4 topping sort using  DFS;
    public static void topSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + "->");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                topSortUtil(graph, e.des, vis, s); // modified dfs
            }
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        int V = 6;
        // 1----0
        // \ |
        // \ |
        // 2 ----3
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph2(graph, V);
        topSort(graph);
    }
}
