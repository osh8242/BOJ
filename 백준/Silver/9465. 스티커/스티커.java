import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1 ; test_case <= T ; test_case++){
            int n = Integer.parseInt(br.readLine());
            int[][] record = new int[2][n+1];
            for(int i = 0 ; i <= 1 ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 1 ; j <= n ; j++){
                    record[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] dp = new int[2][n+1];
            dp[0][1] = record[0][1];
            dp[1][1] = record[1][1];
            for(int col = 2 ; col <= n ; col++){
                dp[0][col] = Math.max(dp[1][col-1] + record[0][col], dp[1][col-2] + record[0][col]);
                dp[1][col] = Math.max(dp[0][col-1] + record[1][col], dp[0][col-2] + record[1][col]);
            }
            sb.append(Math.max(dp[0][n],dp[1][n])+"\n");
        }
        System.out.println(sb);
    }//main(){}
}//class Main{}
