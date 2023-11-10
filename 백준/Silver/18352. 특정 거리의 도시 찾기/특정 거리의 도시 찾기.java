import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K, X;
    static ArrayList<Integer>[] graph;
    static int answer = 0;

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }
        int[] result = daijkstra(X);
        StringBuilder sb = new StringBuilder();
        boolean isExist = false;
        for (int i = 1; i <= N; i++) {
            if (result[i] == K) {
                sb.append(i).append("\n");
                if (!isExist) isExist = true;
            }
        }
        System.out.println(isExist ? sb : -1);
    }

    int[] daijkstra(int start) {
        int[] record = new int[N + 1];
        Arrays.fill(record, Integer.MAX_VALUE);
        record[start] = 0;
        PriorityQueue<History> pq = new PriorityQueue<>();
        pq.add(new History(start, 0));
        while (!pq.isEmpty()) {
            History history = pq.poll();
            int current = history.current;
            int distance = history.distance;
            if (distance > record[current]) continue;
            for (int next : graph[current]) {
                if (record[next] > distance + 1) {
                    record[next] = distance + 1;
                    pq.add(new History(next, distance + 1));
                }
            }
        }
        return record;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    class History implements Comparable<History> {
        private int current;
        private int distance;

        public History(int current, int distance) {
            this.current = current;
            this.distance = distance;
        }

        @Override
        public int compareTo(History o) {
            return this.distance - o.distance;
        }
    }

}
