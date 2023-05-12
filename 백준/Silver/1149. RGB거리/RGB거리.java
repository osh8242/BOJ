import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] record = new int[n+1][3];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            record[i][0] = Integer.parseInt(st.nextToken());
            record[i][1] = Integer.parseInt(st.nextToken());
            record[i][2] = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < 3 ; j++){
                record[i][j] += Math.min(record[i-1][(j+1)%3],record[i-1][(j+2)%3]);
            }
        }
        System.out.println(Math.min(record[n][0],Math.min(record[n][1],record[n][2])));


    } // void main()
} //Class Main