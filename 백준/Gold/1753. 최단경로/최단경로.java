import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E, K;
    static ArrayList<Path>[] paths;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        paths = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) paths[i] = new ArrayList<>();
        K = Integer.parseInt(br.readLine());

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            paths[start].add(new Path(end, cost));
        }

        PriorityQueue<Path> que = new PriorityQueue<>();
        int[] costs = new int[V + 1];
        isVisited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) costs[i] = Integer.MAX_VALUE;
        que.offer(new Path(K, 0));
        costs[K] = 0;
        while (!que.isEmpty()) {
            Path current = que.poll();
            if (isVisited[current.index]) continue;
            isVisited[current.index] = true;
            for (Path next : paths[current.index]) {
                int newCost = costs[current.index] + next.cost;
                if (costs[next.index] > newCost) {
                    costs[next.index] = newCost;
                    que.offer(new Path(next.index, newCost));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(costs[i] == Integer.MAX_VALUE ? "INF" : costs[i]).append("\n");
        }
        System.out.println(sb);
    }

    static class Path implements Comparable<Path> {
        private int index;
        private int cost;

        public Path(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Path o) {
            return this.cost - o.cost;
        }
    }

}