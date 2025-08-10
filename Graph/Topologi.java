package Graph;

import java.util.*;

public class Topologi {

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
        graph[0].add(new Edge(0, 3));
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

    public static void inDegree(ArrayList<Edge>[] graph, int[] inDegree) {
        for (int i = 0; i < graph.length; i++) {
            int v = i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                inDegree[e.des]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph) { //  kanh's  O(E+V) ;
        int indeg[] = new int[graph.length];
        inDegree(graph, indeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.des]--;
                if (indeg[e.des] == 0) {
                    q.add(e.des);
                }
            }
        }
    }

    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.print(path + dest);
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.des, dest, path+src);
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph2(graph, V);
        // topSort(graph);
        printAllPath(graph, 5, 1, "");
        
    }
}
