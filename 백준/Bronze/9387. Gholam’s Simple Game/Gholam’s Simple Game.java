import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            boolean[] yellow = new boolean[m];
            int pos = -1;
            int dir = 0;
            for (int i = 0; i < m; i++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 0) {
                    yellow[i] = true;
                } else if (a == 2) {
                    pos = i;
                    dir = 1;
                } else if (a == 3) {
                    pos = i;
                    dir = -1;
                }
            }
            int cnt = 0;
            for (int step = 0; step < n; step++) {
                int next = pos + dir;
                if (next < 0 || next >= m) {
                    dir = -dir;
                    next = pos + dir;
                }
                pos = next;
                if (yellow[pos]) cnt++;
            }
            sb.append(cnt).append('\n');
        }
        System.out.print(sb.toString());
    }
}
