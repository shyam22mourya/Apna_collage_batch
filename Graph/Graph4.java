package Graph;

import java.util.*;

public class Graph4 {

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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));
        // 1
        graph[1].add(new Edge(1, 3, 40));
        graph[1].add(new Edge(1, 0, 10));

        // 2
        graph[2].add(new Edge(2, 3, 50));
        graph[2].add(new Edge(2, 0, 15));
        // 3
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 0));

    }

    public static void createGraph1(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, 1));
        graph.add(new Edge(1, 3, 7));
        graph.add(new Edge(2, 4, 3));
        graph.add(new Edge(3, 5, 1));
        graph.add(new Edge(4, 3, 2));
        graph.add(new Edge(4, 5, 5));
    }

    public static int[] bellmanFord(ArrayList<Edge> graph, int src, int V) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {

            for (int j = 0; j < V; j++) {
                for (Edge e : graph) {
                    int u = e.src;
                    int v = e.des;
                    int w = e.weight;

                    // negative cycle
                    if (i == V - 1) {
                        return new int[] { -1 };
                    }
                    // Relaxation
                    if (dist[u] != Integer.MAX_VALUE & dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }
        return dist;
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return this.cost - o.cost;
        }
    }

    public static void Prism(ArrayList<Edge>[] graph, int src, int V) {

        boolean[] vis = new boolean[V];
     // MST cost
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        ArrayList<Pair> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (vis[curr.v]) {
                continue;
            }
            vis[curr.v] = true;
            ans.add(new Pair(curr.v, curr.cost));

            for (Edge e : graph[curr.v]) {
                pq.add(new Pair(e.des, e.weight));
            }

        }
        for (Pair p : ans) {
            System.out.println(p.v + " " + p.cost);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        // ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph, V);
        Prism(graph, 0, V);
    }
}
