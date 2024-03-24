import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V, E;
    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        rank = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            queue.offer(new Edge(v1, v2, w));
        }
        int answer = 0;
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (find(edge.v1) != find(edge.v2)) {
                union(edge.v1, edge.v2);
                answer += edge.w;
            }
        }
        System.out.println(answer);
    }

    static int find(int v) {
        if (v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    static void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 != root2) {
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int v1, v2, w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }

}
