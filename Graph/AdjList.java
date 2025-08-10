package Graph;

import java.util.*;

public class AdjList {

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

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        // 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        // 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        // 6
        graph[6].add(new Edge(6, 5, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph) { // O ( V+K);
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                bfsUtil(graph, visit);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge>[] graph, boolean visit[]) { // O ( V+K);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visit[curr]) { // not visit
                System.out.print(curr + " ");
                visit[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) { // add neibour s
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }

    }

    public static void dfs(ArrayList<Edge>[] graph, int curr) {
        boolean visit[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visit[i]) {
                dfsUtil(graph, i, visit);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
        // visit
        System.out.print(curr + " ");
        visited[curr] = true;

        // call for neibour
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.des]) {
                dfsUtil(graph, curr, visited);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean[] vis) {
        // base case
        if (src == des) {
            return true;
        }
        vis[src] = true;
        // kaam
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.des] && hasPath(graph, e.des, des, vis)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph, V);
        System.out.print(hasPath(graph, 0, 3, new boolean[V]));
    }
}