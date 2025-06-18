import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String S = br.readLine();
            int L = S.length();
            int d = gcd(L, 2);
            int P = L / d;
            for (int start = 0; start < 2; start++) {
                for (int i = 0; i < P; i++) {
                    int idx = (start + 2 * i) % L;
                    sb.append(S.charAt(idx));
                }
                sb.append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
