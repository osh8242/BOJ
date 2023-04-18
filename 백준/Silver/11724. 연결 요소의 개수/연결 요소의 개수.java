import java.io.*;
import java.util.*;

public class Main {

    static boolean[] isVisited;
    static boolean[][] isConnected;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n+1];
        isConnected = new boolean[n+1][n+1];
        for(int i =1 ; i <= n ; i++){
            isConnected[i][i] = true;
        }
        for (int i=1;i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isConnected[a][b] = true;
            isConnected[b][a] = true;
        }
        answer = 0;
        for(int i = 1 ; i <= n ; i++){
            if(isVisited[i]==false){
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);

    }

    static void dfs(int start){
        if(isVisited[start]==false) isVisited[start]=true;
        for(int i = 1 ; i <= n ; i++){
            if(isConnected[start][i] == true && isVisited[i] == false){
                dfs(i);
            }
        }
    }
}
