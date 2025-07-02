import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] sp = line.split(" ");
            long W = Long.parseLong(sp[0]);
            long H = Long.parseLong(sp[1]);
            if (W == 0 && H == 0) break;
            long g = gcd(W, H);
            long ans = (W / g) * (H / g);
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
