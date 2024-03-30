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
                if (chars1[i - 1] == chars2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = chars1.length;
        int j = chars2.length;
        int len = dp[chars1.length][chars2.length];
        sb.append(len).append("\n");
        char[] lcs = new char[len];
        while (!(i == 0 || j == 0)) {
            if (dp[i - 1][j] == len) i--;
            else if (dp[i][j - 1] == len) j--;
            else {
                lcs[len-- - 1] = chars1[i-- - 1];
                j--;
            }
        }
        sb.append(lcs);
        System.out.println(sb);

    }

}