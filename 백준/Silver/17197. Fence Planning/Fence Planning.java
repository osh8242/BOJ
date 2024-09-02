import java.io.*;
import java.util.*;

public class Main {
    static class Cow {
        int x, y;
        public Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(x, y);
        }

        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        boolean[] visited = new boolean[N];
        int minPerimeter = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                minPerimeter = Math.min(minPerimeter, bfs(i, adj, cows, visited));
            }
        }

        sb.append(minPerimeter).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }

    static int bfs(int start, List<Integer>[] adj, Cow[] cows, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        int minX = cows[start].x, maxX = cows[start].x;
        int minY = cows[start].y, maxY = cows[start].y;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            Cow cow = cows[node];

            minX = Math.min(minX, cow.x);
            maxX = Math.max(maxX, cow.x);
            minY = Math.min(minY, cow.y);
            maxY = Math.max(maxY, cow.y);

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return 2 * ((maxX - minX) + (maxY - minY));
    }
}
