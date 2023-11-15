import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Path>[] paths;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paths = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) paths[i] = new ArrayList<>();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            paths[start].add(new Path(end, time));
        }

        long[] times = new long[N + 1];
        for (int i = 2; i <= N; i++) times[i] = INF;

        int count = N;
        while (count-- > 0) {
            for (int i = 1; i <= N; i++) {
                if (times[i] == INF) continue;
                for (Path next : paths[i]) {
                    long newTime = times[i] + next.time;
                    if (times[next.index] > newTime) {
                        if (count == 0) {
                            System.out.println(-1);
                            return;
                        }
                        times[next.index] = newTime;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(times[i] == INF ? -1 : times[i]).append("\n");
        }
        System.out.println(sb);
    }

    static class Path {
        private int index;
        private int time;

        public Path(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

}
