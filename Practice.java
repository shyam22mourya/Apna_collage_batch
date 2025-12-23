import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Assingmants.QuueQ;

public class Practice {

    public static void BFS(ArrayList<Edge> graph[], int v) {
        boolean visit[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (!visit[i]) {
                q.offer(i);
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    if (!visit[curr]) {
                        System.out.print(curr + " ");
                        visit[curr] = true;
                        for (int j = 0; j < graph[curr].size(); j++) {
                            Edge newAd = graph[curr].get(j);
                            q.add(newAd.des);
                        }
                    }
                }
            }
        }

    }

    public static void Dfs(ArrayList<Edge> graph[], int curr, boolean[] visit) {
        visit[curr] = true;
        System.out.print(curr + " ");
        // check for neighbours
        for (int j = 0; j < graph[curr].size(); j++) {
            Edge e = graph[curr].get(j);
            if (!visit[e.des]) {
                Dfs(graph, e.des, visit);
            }
        }
    }

    public static boolean haspath(ArrayList<Edge> graph[], int src, int des, boolean vis[]) {
        vis[src] = true;
        if (src == des) {
            return true;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if (!vis[e.des] && haspath(graph, e.des, des, vis)) {
                return true;
            }
        }
        return false;
    }

    // cycle detect using dfs in undirected ;
    public static boolean cycleDelect(ArrayList<Edge> graph[], int curr, int par, boolean vis[]) {
        vis[curr] = true;
        // call for neighbours
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case 2 if not visited so visit
            if (!vis[e.des]) {
                if (cycleDelect(graph, e.des, curr, vis)) {
                    return true;
                }
            }
            // case 1 if curr is visited and para is not this parant ;

            else if (vis[e.des] && e.des != par) {
                return true;
            }
        }
        return false;
    }

    public static boolean cycleDetect(ArrayList<Edge>[] graph, int v) {
        boolean[] vis = new boolean[v];
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                q.add(new Node(i, -1)); // Start BFS with parent as -1

                while (!q.isEmpty()) {
                    Node temp = q.poll();
                    int curr = temp.src;
                    int parent = temp.parent;

                    if (!vis[curr]) {
                        vis[curr] = true;

                        for (Edge e : graph[curr]) {
                            if (!vis[e.des]) {
                                q.add(new Node(e.des, curr));
                            }
                            // If visited and not parent → cycle found
                            else if (e.des != parent) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // BFS node structure
    static class Node {
        int src, parent;

        public Node(int src, int parent) {
            this.src = src;
            this.parent = parent;
        }
    }

    public static boolean bipartit(ArrayList<Edge> graph[], int v) {
        int col[] = new int[v];
        for (int i = 0; i < v; i++) {
            col[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (col[i] == -1) {
                q.add(i);
                while (!q.isEmpty()) {
                    int curr = q.poll();

                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (col[e.des] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.des] = nextCol;
                        } else if (col[e.des] != col[curr]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean bipartite(ArrayList<Edge>[] graph, int v) {
        int color[] = new int[v];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) { // this outside ode for connected graph
                q.offer(i);
                color[i] = 1;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);

                        if (color[e.des] == -1) { // case 1 ; no color
                            int newColor = color[curr] == 0 ? 1 : 0;
                            color[e.des] = newColor;
                            q.add(e.des);
                        } else if (color[curr] == color[e.des]) { // case2 ; color parant
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    // cylcle distaction in directed
    public static boolean cycleDelectDi(ArrayList<Edge>[] graph, int v) {
        boolean visit[] = new boolean[v];
        boolean stack[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visit[i]) {
                if (cycleDelectUtil(graph, i, visit, stack)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean cycleDelectUtil(ArrayList<Edge> graph[], int curr, boolean[] visit, boolean[] stack) {
        stack[curr] = true;
        visit[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.des]) {
                return true;
            }

            if (!visit[e.des]) {
                if (cycleDelectUtil(graph, e.des, visit, stack)) {
                    return true;
                }
            }
        }
        stack[curr] = false;
        return false;
    }

    public static boolean cycleDelectDiBfs(ArrayList<Edge> graph[], int v) {
        boolean visit[] = new boolean[v];
        boolean stack[] = new boolean[v];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        for (int i = 0; i < v; i++) {
            if (!visit[i]) {
                while (!q.isEmpty()) {
                    int c = q.poll();
                    if (!visit[c]) { // case 1 if visited
                        visit[c] = true;
                        stack[c] = true; // case 2
                        for (int j = 0; j < graph[i].size(); j++) {
                            int curr = graph[i].get(j).src;
                            int parent = graph[i].get(j).des;
                            if (!visit[curr]) {
                                visit[curr] = true;
                                stack[curr] = true;
                            } else if (curr != parent) {
                                return true;
                            }

                        }
                    }

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // creating steps
        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];

        for (int i = 0; i < V; i++) {
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
        graph[3].add(new Edge(3, 2));

        // BFS(graph, V);
        boolean visit[] = new boolean[V];
        // Dfs(graph, 0, visit);
        // System.out.println(haspath(graph, 0, 3, visit));
        // System.out.println(cycleDelect(graph, 0, -1, visit));
        // System.out.println(cycleDetect(graph, V));
        // System.out.println(bipartite(graph, V));
    }
}

class Edge {
    int src, des;

    Edge(int src, int des) {
        this.src = src;
        this.des = des;

    }
}