import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine().trim());
        Arrays.sort(a);
        int i = 0, j = n - 1, ans = 0;
        while (i < j) {
            int s = a[i] + a[j];
            if (s == x) {
                ans++;
                i++;
                j--;
            } else if (s < x) {
                i++;
            } else {
                j--;
            }
        }
        System.out.print(ans);
    }
}
