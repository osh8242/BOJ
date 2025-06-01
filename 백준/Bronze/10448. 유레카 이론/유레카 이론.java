import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] tris = new int[50]; // 충분히 큰 크기
        int tCount = 0;
        for (int n = 1;; n++) {
            int t = n * (n + 1) / 2;
            if (t > 1000) break;
            tris[tCount++] = t;
        }

        boolean[] can = new boolean[1001];
        for (int i = 0; i < tCount; i++) {
            for (int j = 0; j < tCount; j++) {
                for (int k = 0; k < tCount; k++) {
                    int sum = tris[i] + tris[j] + tris[k];
                    if (sum <= 1000) {
                        can[sum] = true;
                    }
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            sb.append(can[K] ? "1\n" : "0\n");
        }
        System.out.print(sb.toString());
    }
}
