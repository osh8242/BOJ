import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(9);
            return;
        }
        int[][] dp = new int[10][n+1];
        for(int i = 1 ; i < 10 ; i++){
            dp[i][1] = 1;
        }
        for(int j = 2 ; j <= n ; j++){
            dp[0][j] = (dp[1][j-1])%1000000000;
            dp[1][j] = (dp[0][j-1] + dp[2][j-1])%1000000000;
            dp[2][j] = (dp[1][j-1] + dp[3][j-1])%1000000000;
            dp[3][j] = (dp[2][j-1] + dp[4][j-1])%1000000000;
            dp[4][j] = (dp[3][j-1] + dp[5][j-1])%1000000000;
            dp[5][j] = (dp[4][j-1] + dp[6][j-1])%1000000000;
            dp[6][j] = (dp[5][j-1] + dp[7][j-1])%1000000000;
            dp[7][j] = (dp[6][j-1] + dp[8][j-1])%1000000000;
            dp[8][j] = (dp[7][j-1] + dp[9][j-1])%1000000000;
            dp[9][j] = (dp[8][j-1])%1000000000;
        }
        int sum = 0;
        for(int i = 0 ; i < 10 ; i++){
            sum += dp[i][n];
            sum %= 1000000000;
        }
        System.out.println(sum);
    }

}
