import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars1 = br.readLine().toCharArray();
        char[] chars2 = br.readLine().toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (chars1[i-1] == chars2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }
        System.out.println(dp[chars1.length][chars2.length]);
    }
    
}
