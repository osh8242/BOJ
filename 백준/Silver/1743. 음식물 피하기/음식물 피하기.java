import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, m, k, max, count;
    static boolean[][] map;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n+2][m+2];
        k = Integer.parseInt(st.nextToken());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
        }
        max = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <=m ; j++){
                if(map[i][j]) {
                    count = 1;
                    map[i][j] = false;
                    dfs(i,j);
                }
            }
        }
        System.out.println(max);

    }

    static void dfs(int row, int col){
        if(count > max) max = count;
        for(int i = 0 ; i < 4 ; i++){
            if(map[row+dx[i]][col+dy[i]]) {
                count++;
                map[row+dx[i]][col+dy[i]] = false;
                dfs(row+dx[i], col+dy[i]);
            }
        }
    }

}
