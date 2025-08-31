import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] w = new int[N];
        int[] c = new int[N];
        int maxW = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            if (w[i] > maxW) maxW = w[i];
        }

        TreeSet<Integer> cand = new TreeSet<>();
        cand.add(0);
        for (int i = 0; i < N; i++) {
            cand.add(w[i]);
            int p = c[i] + 1;
            if (p <= maxW) cand.add(p);
        }

        long bestProfit = Long.MIN_VALUE;
        int bestPrice = 0;
        for (int p : cand) {
            long profit = 0;
            for (int i = 0; i < N; i++) {
                if (w[i] >= p && p > c[i]) profit += (long)(p - c[i]);
            }
            if (profit > bestProfit || (profit == bestProfit && p < bestPrice)) {
                bestProfit = profit;
                bestPrice = p;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (bestProfit <= 0) sb.append(0).append('\n');
        else sb.append(bestPrice).append('\n');
        System.out.print(sb.toString());
    }
}
