import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Long> snowflakeSet = new HashSet<>(n * 2);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] snowflake = new int[6];
            for (int j = 0; j < 6; j++) {
                snowflake[j] = Integer.parseInt(st.nextToken());
            }
            long canonicalHash = getCanonicalHash(snowflake);
            if (snowflakeSet.contains(canonicalHash)) {
                System.out.println("Twin snowflakes found.");
                return;
            }
            snowflakeSet.add(canonicalHash);
        }
        System.out.println("No two snowflakes are alike.");
    }
    
    private static long getCanonicalHash(int[] arr) {
        long minHash = Long.MAX_VALUE;
        long base = 1000003L;

        for (int i = 0; i < 6; i++) {
            long hash = 0;
            for (int j = 0; j < 6; j++) {
                hash = hash * base + arr[(i + j) % 6];
            }
            if (hash < minHash) {
                minHash = hash;
            }
        }

        for (int i = 0; i < 6; i++) {
            long hash = 0;
            for (int j = 0; j < 6; j++) {
                int idx = (i - j + 6) % 6;
                hash = hash * base + arr[idx];
            }
            if (hash < minHash) {
                minHash = hash;
            }
        }
        return minHash;
    }
}
