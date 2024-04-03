import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static Matrix[] matrices;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N][N];
        for(int[] arr : dp) Arrays.fill(arr, Integer.MAX_VALUE);
        matrices = new Matrix[N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrices[i] = new Matrix(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(recursive(0,N-1));

    }

    static int recursive(int s, int e){
        if(s==e) return 0;
        if(dp[s][e] < Integer.MAX_VALUE) return dp[s][e];
        for(int m = s ; m < e ; m++){
            int count = recursive(s,m) + recursive(m+1, e)
                    + matrices[s].r * matrices[m].c * matrices[e].c;
            dp[s][e] = Math.min(dp[s][e], count);
        }
        return dp[s][e];
    }


    static class Matrix {
        int r;
        int c;
        public Matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
