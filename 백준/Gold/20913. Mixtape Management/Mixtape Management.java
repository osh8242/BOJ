import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[n+1];
        for (int i = 1; i <= n; i++) p[i] = Integer.parseInt(st.nextToken());
        int K = String.valueOf(n).length();
        int prefixLen = 1 + K;
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            StringBuilder s = new StringBuilder();
            s.append('1');
            String idx = String.valueOf(i);
            for (int z = 0; z < K - idx.length(); z++) s.append('0');
            s.append(idx);
            for (int z = 0; z < p[i]; z++) s.append('0');
            if (i > 1) out.append(' ');
            out.append(s.toString());
        }
        System.out.println(out.toString());
    }
}
