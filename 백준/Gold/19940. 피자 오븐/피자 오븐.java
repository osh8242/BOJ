import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] adjustUp(int r) {
        int t = r / 10, o = r % 10;
        int aT = t, aO = o, aN = 0, costA = aT + aO;
        int bT = t + 1, bO = 0, bN = 10 - o, costB = (o == 0) ? Integer.MAX_VALUE : bT + bN;
        if (costA < costB) return new int[]{aT, 0, aO, aN};
        if (costB < costA) return new int[]{bT, 0, bO, bN};
        if (aT != bT) return (aT < bT) ? new int[]{aT, 0, aO, aN} : new int[]{bT, 0, bO, bN};
        return (aO <= bO) ? new int[]{aT, 0, aO, aN} : new int[]{bT, 0, bO, bN};
    }

    static int[] adjustDown(int r) {
        int t = r / 10, o = r % 10;
        int aT = t, aN = o, aO = 0, costA = aT + aN;
        int bT = t + 1, bN = 0, bO = 10 - o, costB = (o == 0) ? Integer.MAX_VALUE : bT + bO;
        if (costA < costB) return new int[]{0, aT, aO, aN};
        if (costB < costA) return new int[]{0, bT, bO, bN};
        if (aT != bT) return (aT < bT) ? new int[]{0, aT, aO, aN} : new int[]{0, bT, bO, bN};
        return (aO <= bO) ? new int[]{0, aT, aO, aN} : new int[]{0, bT, bO, bN};
    }

    static int[] solve(int n) {
        int h = n / 60, r = n % 60;

        int[] up = adjustUp(r);
        int[] candA = {h, up[0], up[1], up[2], up[3]};
        int costA = h + up[0] + up[1] + up[2] + up[3];

        int m = (r == 0) ? 0 : 60 - r;
        int[] down = adjustDown(m);
        int[] candB = {h + 1, 0, down[1], down[2], down[3]};
        int costB = (h + 1) + down[1] + down[2] + down[3];

        if (costA != costB) return (costA < costB) ? candA : candB;
        for (int i = 0; i < 5; i++) {
            if (candA[i] != candB[i]) return (candA[i] < candB[i]) ? candA : candB;
        }
        return candA;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] ans = solve(n);
            sb.append(ans[0]).append(' ')
              .append(ans[1]).append(' ')
              .append(ans[2]).append(' ')
              .append(ans[3]).append(' ')
              .append(ans[4]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
