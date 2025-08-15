import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            int[] a = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
            int l = 0, r = N - 1;
            int maxSoFar = Integer.MIN_VALUE;
            int paid = 0;
            while (l <= r) {
                int take;
                if (a[l] <= a[r]) take = a[l++]; else take = a[r--];
                if (take >= maxSoFar) {
                    paid++;
                    maxSoFar = take;
                }
            }
            sb.append("Case #").append(tc).append(": ").append(paid).append('\n');
        }
        System.out.print(sb.toString());
    }
}
