import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] prices;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prices = new int[N + 1];
        dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            prices[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            for(int j = 1 ; j <= i ; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + prices[j]);
            }
        }
        System.out.println(dp[N]);
    }
}
