import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] friends;
    static int allCovered;
    static int minCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int T = Integer.parseInt(line.trim());
            while (T-- > 0) {
                n = Integer.parseInt(br.readLine().trim());
                friends = new int[n];
                for (int i = 0; i < n; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int d = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < d; j++) {
                        int f = Integer.parseInt(st.nextToken()) - 1;
                        friends[i] |= (1 << f);
                        friends[f] |= (1 << i);
                    }
                    friends[i] |= (1 << i);
                }
                allCovered = (1 << n) - 1;
                minCount = n;
                backtrack(0, 0, 0);
                sb.append(minCount).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void backtrack(int start, int count, int covered) {
        if (covered == allCovered) {
            minCount = Math.min(minCount, count);
            return;
        }
        if (count >= minCount) return;
        if (start >= n) return;

        backtrack(start + 1, count, covered);
        backtrack(start + 1, count + 1, covered | friends[start]);
    }
}
