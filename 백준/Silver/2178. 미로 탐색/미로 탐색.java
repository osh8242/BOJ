import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[][] map;
    public static int[] dr = {1, 0, -1, 0};
    public static int[] dc = {0, 1, 0, -1,};
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+2][m+2];
        answer = n*m;
        for(int i =1 ; i <= n ; i++){
            String line = br.readLine();
            for (int j = 1 ; j <= m ; j++){
                if(line.charAt(j-1) == '1') map[i][j] = 1;
            }
        }
        dfs(1,1,1);
        System.out.println(answer);

    }

    public static void dfs(int i, int j, int depth){
        if(i==n && j==m && depth < answer) answer = depth;
        if(map[i][j] == 1 || map[i][j] > depth){
            map[i][j] = depth;
            depth++;
            for(int d = 0 ; d < 4 ; d++){
                if(map[i+dr[d]][j+dc[d]] == 1 || map[i+dr[d]][j+dc[d]] > depth) dfs(i+dr[d], j+dc[d], depth);
            }
        }
    }
}