import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new boolean[n+1][n+1];
        for (int i = 1 ; i <= n ; i ++){
             st = new StringTokenizer(br.readLine());
             for(int j = 1 ; j <= n ; j++) {
                 if(Integer.parseInt(st.nextToken()) == 1) map[i][j] = true;
             }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(map[i][j] == true) fw(i,j);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= n ; i++){
            for (int j = 1 ; j <= n ; j++){
                if(map[i][j] == true) sb.append("1 ");
                else  sb.append("0 ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void fw(int i, int j){
        for(int k = 1 ; k <= n ; k++){
            if(map[j][k] == true && map[i][k] == false) {
                map[i][k] = true;
                fw(i,k);
            }
        }

    }
}