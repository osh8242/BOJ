import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            StringTokenizer st = new StringTokenizer(line);
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if (B == 0 && N == 0) break;
            st = new StringTokenizer(br.readLine());
            int[] R = new int[B];
            for (int i = 0; i < B; i++) R[i] = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int D = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                R[D - 1] -= V;
                R[C - 1] += V;
            }
            boolean ok = true;
            for (int v : R) {
                if (v < 0) { ok = false; break; }
            }
            sb.append(ok ? 'S' : 'N').append('\n');
        }
        System.out.print(sb.toString());
    }
}
