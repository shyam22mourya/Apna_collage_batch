package Graph;

import java.util.*;

public class  KosrajuALorithm{

    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void createGraph2(ArrayList<Edge>[] graph, int size) { // O(V+E);directed
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        // 1
        graph[1].add(new Edge(1, 0));

        // 2
        graph[2].add(new Edge(2, 1));

        // 3
        graph[3].add(new Edge(3, 4));

    }

    public static void typoSort(ArrayList<Edge>[] graph, int curr, Stack<Integer> st, boolean visit[]) {
        visit[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visit[e.des]) {
                typoSort(graph, e.des, st, visit);
            }
        }
        st.push(curr);
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visit[]) {
        visit[curr] = true;
        System.out.print(curr + " ");
        for (Edge e : graph[curr]) {
            if (!visit[e.des]) {
                dfs(graph, e.des, visit);
            }
        }
    }

    public static void kosraju(ArrayList<Edge>[] graph, int V) {
        boolean visit[] = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        // step1 topology sort
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                typoSort(graph, i, st, visit);
            }
        }

        // step 2 Transpose the graph
        ArrayList<Edge>[] traspose = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            traspose[i] = new ArrayList<>();
            visit[i] = false;
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);// e.src-> e.des ;
                traspose[e.des].add(new Edge(e.des, e.src));// revrese edge ;
            }
        }

        // step 3
        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!visit[curr]) {
                System.out.print("SCC -> ");
                dfs(traspose, curr, visit);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph2(graph, V);
        kosraju(graph, V);
    }
}
