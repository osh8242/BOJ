import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] cap = new long[3];
        long[] milk = new long[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cap[i] = Long.parseLong(st.nextToken());
            milk[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < 100; i++) {
            int from = i % 3;
            int to = (from + 1) % 3;
            long amount = Math.min(milk[from], cap[to] - milk[to]);
            milk[from] -= amount;
            milk[to] += amount;
        }

        StringBuilder sb = new StringBuilder();
        for (long m : milk) {
            sb.append(m).append('\n');
        }
        System.out.print(sb);
    }
}
