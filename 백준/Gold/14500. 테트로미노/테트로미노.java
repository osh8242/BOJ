import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int n, m;
    static boolean[][] isVisit;
    static int[][] map;
    static int sum = Integer.MIN_VALUE;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isVisit = new boolean[n][m];
        map = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                isVisit[i][j] = true;
                dfs(i,j,map[i][j],1);
                isVisit[i][j] = false;
            }
        }
        System.out.println(sum);

    } // void main()

    static void dfs(int row, int col, int score, int depth){
        if(depth == 4) {
            if(score > sum) sum = score;
            return;
        }
        for(int v = 0 ; v < 4 ; v++){
            int sr = row+dr[v];
            int sc = col+dc[v];
            if(sr < 0 || sc < 0 || sr >= n || sc >= m) continue;
            else if(!isVisit[sr][sc]){
                isVisit[sr][sc] = true;
                dfs(sr, sc, score+map[sr][sc],depth+1);
                if(depth==2) dfs (row,col,score+map[sr][sc],depth+1);
                isVisit[sr][sc] = false;
            }
        }

    } // void dfs()

} //Class Main