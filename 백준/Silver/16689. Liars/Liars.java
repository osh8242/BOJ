import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        int ans = -1;
        for (int k = n; k >= 0; k--) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] <= k && k <= b[i]) {
                    cnt++;
                }
            }
            if (cnt == k) {
                ans = k;
                break;
            }
        }
        System.out.println(ans);
    }
}
