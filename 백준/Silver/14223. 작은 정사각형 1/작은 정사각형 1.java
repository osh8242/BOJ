import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        long[] x = new long[N], y = new long[N];
        for (int i = 0; i < N; i++) {
            String[] sp = br.readLine().split(" ");
            x[i] = Long.parseLong(sp[0]);
            y[i] = Long.parseLong(sp[1]);
        }

        long best = Long.MAX_VALUE;

        // 제외집합 크기 0
        best = Math.min(best, computeArea(x, y, N, -1, -1));

        // 제외집합 크기 1
        for (int i = 0; i < N; i++) {
            best = Math.min(best, computeArea(x, y, N, i, -1));
        }

        // 제외집합 크기 2
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                best = Math.min(best, computeArea(x, y, N, i, j));
            }
        }

        System.out.println(best);
    }

    // 제외할 인덱스 e1, e2 (e2<0 이면 하나만 제외)
    static long computeArea(long[] x, long[] y, int N, int e1, int e2) {
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (i == e1 || i == e2) continue;
            if (x[i] < minX) minX = x[i];
            if (x[i] > maxX) maxX = x[i];
            if (y[i] < minY) minY = y[i];
            if (y[i] > maxY) maxY = y[i];
        }
        long dx = maxX - minX;
        long dy = maxY - minY;
        long L = Math.max(dx, dy) + 2;
        return L * L;
    }
}
