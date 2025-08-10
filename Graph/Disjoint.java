package Graph;
import java.util.*;
public class Disjoint {

    static class Edge implements Comparable<Edge> {
        int src;
        int des;
        int weight;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.weight = w;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static void creatgraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));
    }

    static int n = 4; // Verticis
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) { // O(1)
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void kruskalMst(ArrayList<Edge> graph, int V) {
        // step 1
        init();
        Collections.sort(graph);
        int count = 0;
        int mstcost = 0;
        // step 2
        for (int i = 0; count < V - 1; i++) {
            Edge e = graph.get(i);
            // ( src , dest , wt ) ;
            int parA = find(e.src);// src == a ;
            int parB = find(e.des); // dest = b ;
            if (parA != parB) {
                union(parA, parB);
                mstcost += e.weight;
                count++;
            }
        }
        System.out.println(mstcost);
    }

    // flood fill algorithm  based of dfs 
    public static void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol) {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }
        vis[sr][sc] = true;
        image[sr][sc] = color;
        helper(image, sr, sc-1, color, vis, orgCol);
        helper(image, sr, sc+1, color, vis, orgCol);
        helper(image, sr-1, sc, color, vis, orgCol);
        helper(image, sr+1, sc, color, vis, orgCol);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        helper(image, sr,sc,color, vis, image[sr][sc]);
        return image;
    }



    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
        creatgraph(graph);
        kruskalMst(graph, n);
    }
}
//