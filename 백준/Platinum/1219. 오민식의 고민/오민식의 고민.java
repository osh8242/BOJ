import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, S, E, M;
    static ArrayList<Path>[] paths;
    static int[] earnings;
    static final Long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paths = new ArrayList[N];
        for (int i = 0; i < N; i++) paths[i] = new ArrayList<>();
        earnings = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            paths[start].add(new Path(start, end, cost));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            earnings[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (Path path : paths[i]) {
                path.cost -= earnings[path.end];
            }
        }

        long[] record = new long[N];
        for (int i = 0; i < N; i++) record[i] = INF;
        record[S] = -earnings[S];

        for (int count = 1; count < N; count++) {
            for (int i = 0; i < N; i++) {
                for (Path path : paths[i]) {
                    if (record[path.start] == INF) continue;
                    long newCost = record[path.start] + path.cost;
                    if (record[path.end] > newCost) {
                        record[path.end] = newCost;
                    }
                }
            }
        }
        if (record[E] == INF) {
            System.out.println("gg");
        } else {
            for (int count = 0; count < N; count++) {
                for (int i = 0; i < N; i++) {
                    for (Path path : paths[i]) {
                        if (record[path.start] == INF) continue;
                        if (record[path.start] == -INF) {
                            record[path.end] = -INF;
                        }
                        long newCost = record[path.start] + path.cost;
                        if (record[path.end] > newCost) {
                            record[path.end] = -INF;
                        }
                    }
                }
            }

            if (record[E] == -INF) System.out.println("Gee");
            else System.out.println(-record[E]);
        }

    }

    static class Path {
        int start, end, cost;

        public Path(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

}
