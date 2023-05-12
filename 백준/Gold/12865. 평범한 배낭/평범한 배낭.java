import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] record = new int[n+1][k+1];

        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            for(int j = 1 ; j <= k ; j++){
                if(j < w) record[i][j] = record[i-1][j];
                else record[i][j] = Math.max(record[i-1][j-w]+v, record[i-1][j]);
            }
        }

        System.out.println(record[n][k]);

    } // void main()
} //Class Main