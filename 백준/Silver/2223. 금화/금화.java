import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long t = Long.parseLong(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m == 0) {
            System.out.println(t * x);
            return;
        }

        long K = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long d = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            long ki = (d - 1) / s; // floor((d-1)/s)
            if (ki < K) K = ki;
        }

        if (K == 0) {
            System.out.println(0);
            return;
        }

        long first = Math.min(t, K);
        long rest = t - first;
        long P = first + (rest / 2); // floor
        long answer = P * x;
        System.out.println(answer);
    }
}
