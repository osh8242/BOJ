import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] rect = new int[3][2];
        long areaSum = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            rect[i][0] = H;
            rect[i][1] = W;
            areaSum += 1L * H * W;
        }
        int S = (int)Math.sqrt(areaSum);
        if (1L * S * S != areaSum) {
            System.out.println("NO");
            return;
        }
        int[] perm = {0,1,2};
        boolean ok = false;
        do {
            for (int mask = 0; mask < 8; mask++) {
                int[] h = new int[3];
                int[] w = new int[3];
                for (int i = 0; i < 3; i++) {
                    int idx = perm[i];
                    if (((mask >> i) & 1) == 1) {
                        h[i] = rect[idx][1];
                        w[i] = rect[idx][0];
                    } else {
                        h[i] = rect[idx][0];
                        w[i] = rect[idx][1];
                    }
                }
                if (h[0] == S && h[1] == S && h[2] == S) {
                    if (w[0] + w[1] + w[2] == S) {
                        ok = true; break;
                    }
                }
                if (h[0] == S) {
                    int rem = S - w[0];
                    if (rem > 0 && w[1] == rem && w[2] == rem && (h[1] + h[2] == S)) {
                        ok = true; break;
                    }
                }
            }
            if (ok) break;
        } while (nextPermutation(perm));
        System.out.println(ok ? "YES" : "NO");
    }

    private static boolean nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 2;
        while (i >= 0 && a[i] >= a[i+1]) i--;
        if (i < 0) return false;
        int j = n - 1;
        while (a[j] <= a[i]) j--;
        swap(a, i, j);
        reverse(a, i+1, n-1);
        return true;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) swap(a, l++, r--);
    }
}
