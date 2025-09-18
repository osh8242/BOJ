import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] heights = new long[N];
        for (int i = 0; i < N; i++) {
            heights[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(heights);
        for (int i = 0; i < N / 2; i++) {
            long temp = heights[i];
            heights[i] = heights[N - 1 - i];
            heights[N - 1 - i] = temp;
        }
        long MOD = 1000000007L;
        long total = 0;
        for (long h : heights) {
            total = (total * 2 % MOD + h % MOD) % MOD;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(total);
        System.out.println(sb);
    }
}
