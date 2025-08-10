package Graph;

import java.util.ArrayList;

public class Tarjans {
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        // 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        // 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        // 3
        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 4));
        // graph[5].add(new Edge(5, 3));

    }

    public static void DFS(ArrayList<Edge>[] graph, int curr, int parent, int dt[],
            int low[], boolean visit[], int time) {
        visit[curr] = true;
        dt[curr] = low[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.des;
            // step 1
            if (neigh == parent) {
                continue;
            } else if (!visit[neigh]) {// step 2
                DFS(graph, neigh, curr, dt, low, visit, time);
                low[curr] = Math.min(low[curr], low[neigh]);
                // step found brige condition
                if (dt[curr] < low[neigh]) {
                    System.out.printf("brige edge at %d -> %d ", curr, neigh);
                }
            } else { // step 3 if neigh is visit backadge ; 
                low[curr] = Math.min(low[curr], dt[neigh]);
            }

        }
    }

    public static void targanBridge(ArrayList<Edge>[] graph, int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean[] visit = new boolean[V];
        int time = 0;

        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                DFS(graph, i, -1, dt, low, visit, time);
            }
        }

    }

    public static void dfsArt(ArrayList<Edge>[] graph, int curr, int parent, int dt[],
            int low[], boolean visit[], int time, boolean[] calling) {
        visit[curr] = true;
        dt[curr] = low[curr] = ++time;
        int child = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.des;
            if (parent == neigh) {
                continue;
            } else if (visit[neigh]) {
                low[curr] = Math.min(low[curr], dt[neigh]);
            } else {
                dfsArt(graph, neigh, curr, dt, low, visit, time, calling);//(i)
                low[curr] = Math.min(low[curr], low[neigh]);//(ii)
                if (parent != -1 && dt[curr] <= low[neigh]) {//(iii)
                    calling[curr] = true;
                }
                child++;
            }
        }
        if (parent == -1 && child > 1) {
            calling[curr] = true;
        }
    }

    public static void ArticulationPoint(ArrayList<Edge>[] graph, int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean visit[] = new boolean[V];
        boolean coling[] = new boolean[V];
        int time = 0;
        for (int i = 0; i < V; i++) {
            if (!visit[i]) {
                dfsArt(graph, i, -1, dt, low, visit, time, coling);
            }
        }

        for (int i = 0; i < V; i++) {
            if (coling[i]) {
                System.out.println(i);
            }
        } 

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph2(graph, V);
        // targanBridge(graph, V);
        ArticulationPoint(graph, V);
    }

}
