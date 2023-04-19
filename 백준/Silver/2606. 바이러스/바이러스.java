import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check;
    static boolean[][] connect;
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        check = new boolean[n+1];
        connect = new boolean[n+1][n+1];
        for (int i = 0 ; i < m ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connect[a][b] = true;
            connect[b][a] = true;
        }
        check[1] = true;
        dfs(1);
        System.out.println(answer);

    }

    public static void dfs(int num){
        if(check[num] == false) {
            check[num] = true;
            answer++;
        }
        for(int i = 2; i<=n ; i++){
            if(check[i] == false && connect[num][i] == true) dfs(i);
        }
    }
}