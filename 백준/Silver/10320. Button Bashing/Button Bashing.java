import java.io.*;
import java.util.*;

public class Main {
    static final int MAXT = 3600;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int tc = Integer.parseInt(br.readLine().trim());
        for (int caseNum = 0; caseNum < tc; caseNum++) {
            String line;
            do {
                line = br.readLine();
            } while (line != null && line.trim().isEmpty());
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] btn = new int[n];
            for (int i = 0; i < n; i++) btn[i] = Integer.parseInt(st.nextToken());

            int[] dist = new int[MAXT + 1];
            Arrays.fill(dist, -1);
            ArrayDeque<Integer> q = new ArrayDeque<>();
            dist[0] = 0;
            q.add(0);

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int b : btn) {
                    int v = u + b;
                    if (v < 0) v = 0;
                    else if (v > MAXT) v = MAXT;
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        q.add(v);
                    }
                }
            }

            int presses = -1, extra = 0;
            for (int i = t; i <= MAXT; i++) {
                if (dist[i] != -1) {
                    presses = dist[i];
                    extra = i - t;
                    break;
                }
            }
            out.append(presses).append(' ').append(extra).append('\n');
        }
        System.out.print(out.toString());
    }
}
