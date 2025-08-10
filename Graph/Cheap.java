package Graph;

import java.util.*;

public class Cheap {
    static class Edge {
        int src;
        int des;
        int cost;

        public Edge(int s, int d, int c) {
            this.src = s;
            this.des = d;
            this.cost = c;
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    static class Edge2 implements Comparable<Edge2> {
        int des;
        int cost;

        public Edge2(int d, int c) {
            this.des = d;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge2 e) {
            return this.cost - e.cost;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] flights) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            int s = flights[i][0];
            int d = flights[i][1];
            int c = flights[i][2];

            graph[s].add(new Edge(s, d, c));
        }
    }

    public static int cheapestFights(int[][] flights, int src, int des, int k, int n) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, flights);

        // Distance array to store the minimum cost to reach each node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Min-Heap Priority Queue based on cost
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr.stops > k) {
                continue;
            }

            for (Edge e : graph[curr.v]) {

                int nextCost = curr.cost + e.cost;

                // Update distance if a cheaper cost is found
                if (nextCost < dist[e.des]) {
                    dist[e.des] = nextCost;
                    q.add(new Info(e.des, nextCost, curr.stops + 1));
                }
            }
        }

        return dist[des] == Integer.MAX_VALUE ? -1 : dist[des];
    }

    public static int connectingCitys(int[][] cities) {
        PriorityQueue<Edge2> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge2(0, 0));
        int ans = 0;

        while (!pq.isEmpty()) {
            Edge2 curr = pq.poll();
            if (vis[curr.des]) {
                continue;
            }

            vis[curr.des] = true;
            ans += curr.cost;
            for (int i = 0; i < cities.length; i++) {
                if (cities[curr.des][i] != 0) {
                    pq.add(new Edge2(i, cities[curr.des][i]));
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int flights[][] = { { 0, 1, 100 }, { 0, 2, 100 }, { 1, 2, 100 }, { 1, 3, 500
        // }, { 2, 3, 200 } };
        int cities[][] = {
                { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 }
        };
        System.out.println(connectingCitys(cities));
    }
}
