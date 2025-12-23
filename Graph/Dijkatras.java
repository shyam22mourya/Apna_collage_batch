package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge {
    int src;
    int des;
    int weight;

    public Edge(int src, int des, int wt) {
        this.src = src;
        this.des = des;
        this.weight = wt;
    }

}

class Pair implements Comparable<Pair> {
    int p;
    int path;

    public Pair(int p, int path) {
        this.p = p;
        this.path = path;
    }

    @Override
    public int compareTo(Pair p2) {
        return this.path - p2.path;
    }
}

public class Dijkatras {

    public static void createGraph(ArrayList<Edge>[] graph, int size) {
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // 1
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));
        // 2

        graph[2].add(new Edge(2, 4, 3));

        // 3
        graph[3].add(new Edge(3, 5, 1));

        // 4
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    public static void dijkatras(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];// distance array 
        boolean vis[] = new boolean[graph.length];//visited virtex*

        // Initialize all distances to Integer.MAX_VALUE
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0; // Source distance is 0

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); // Add source node to the priority queue

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            // If the node is already visited, skip it
            if (vis[curr.p])
                continue;

            vis[curr.p] = true; // Mark the current node as visited

            // Traverse neighbors
            for (Edge e : graph[curr.p]) {
                int u = e.src;
                int v = e.des;
                int wt = e.weight;

                // Relaxation step: Update distance if a shorter path is found
                if (!vis[v] && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // Print all source to vertices shortest distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF "); // For unreachable nodes
            } else {
                System.out.print(dist[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph, 6);
        int src = 0;
        dijkatras(graph, src);
    }

}