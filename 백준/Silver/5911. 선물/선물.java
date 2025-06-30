import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nb = br.readLine().split(" ");
        int N = Integer.parseInt(nb[0]);
        long B = Long.parseLong(nb[1]);
        long[] fullCost = new long[N];
        long[] halfCost = new long[N];
        for (int i = 0; i < N; i++) {
            String[] ps = br.readLine().split(" ");
            long P = Long.parseLong(ps[0]);
            long S = Long.parseLong(ps[1]);
            fullCost[i] = P + S;
            halfCost[i] = (P / 2) + S;
        }

        int ans = 0;
        long[] others = new long[N - 1];
        for (int i = 0; i < N; i++) {
            long costWithCoupon = halfCost[i];
            if (costWithCoupon > B) continue;
            int idx = 0;
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                others[idx++] = fullCost[j];
            }
            Arrays.sort(others);
            long sum = costWithCoupon;
            int cnt = 1;
            for (long c : others) {
                if (sum + c <= B) {
                    sum += c;
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt > ans) ans = cnt;
        }

        System.out.print(ans);
    }
}
