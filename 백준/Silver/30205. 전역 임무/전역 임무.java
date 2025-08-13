import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st0 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st0.nextToken());
        int M = Integer.parseInt(st0.nextToken());
        long P = Long.parseLong(st0.nextToken());
        for (int i = 0; i < N; i++) {
            List<Long> enemies = new ArrayList<>();
            int items = 0;
            int read = 0;
            while (read < M) {
                String line = br.readLine();
                if (line == null) break;
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens() && read < M) {
                    long x = Long.parseLong(st.nextToken());
                    if (x == -1) items++;
                    else enemies.add(x);
                    read++;
                }
            }
            Collections.sort(enemies);
            int idx = 0;
            while (idx < enemies.size()) {
                if (enemies.get(idx) <= P) {
                    P += enemies.get(idx);
                    idx++;
                } else {
                    if (items > 0) {
                        P = P * 2;
                        items--;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }
            while (items > 0) {
                P = P * 2;
                items--;
            }
        }
        System.out.println(1);
    }
}
