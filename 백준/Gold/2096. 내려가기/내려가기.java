import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map, maxDp, minDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n+1][3];
        maxDp = new int[n+1][3];
        minDp = new int[n+1][3];
        for(int i = 1 ; i <= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                switch (j){
                    case 0 : {
                        maxDp[i][j] = map[i][j] + Math.max(maxDp[i-1][j],maxDp[i-1][j+1]);
                        minDp[i][j] = map[i][j] + Math.min(minDp[i-1][j],minDp[i-1][j+1]); break;
                    }
                    case 1 : {
                        maxDp[i][j] = map[i][j] + Math.max(maxDp[i-1][j], Math.max(maxDp[i-1][j-1],maxDp[i-1][j+1]));
                        minDp[i][j] = map[i][j] + Math.min(minDp[i-1][j], Math.min(minDp[i-1][j-1],minDp[i-1][j+1])); break;
                    }
                    case 2 : {
                        maxDp[i][j] = map[i][j] + Math.max(maxDp[i-1][j],maxDp[i-1][j-1]);
                        minDp[i][j] = map[i][j] + Math.min(minDp[i-1][j],minDp[i-1][j-1]); break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(maxDp[n][0], Math.max(maxDp[n][1],maxDp[n][2]))+" ");
        sb.append(Math.min(minDp[n][0], Math.min(minDp[n][1],minDp[n][2])));
        System.out.println(sb);

    } // main(){}

} // class Main{}
