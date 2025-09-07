import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] cnt = new int[201];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                int a = (s + 1) / 2;
                int b = (t + 1) / 2;
                if (a > b) { int tmp = a; a = b; b = tmp; }
                for (int k = a; k <= b; k++) cnt[k]++;
            }
            int mx = 0;
            for (int v : cnt) if (v > mx) mx = v;
            sb.append(mx * 10).append('\n');
        }
        System.out.print(sb.toString());
    }
}
