import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] sp = br.readLine().split(" ");
            long A = Long.parseLong(sp[0]) + Long.parseLong(sp[1]);
            long ans = A * A * (A - 1) / 2;
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
