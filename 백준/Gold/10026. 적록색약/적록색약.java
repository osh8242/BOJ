import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean[][] isVisit;
    public static char[][] map;
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0,0,1, -1};
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        isVisit = new boolean[n+2][n+2];
        map = new char[n+2][n+2];
        for(int i =1 ; i <= n ; i++){
            String temp = br.readLine();
            for(int j = 1 ; j <= n ; j++){
                map[i][j] = temp.charAt(j-1);
            }
        }
        //정상인
        int blocks = 0;
        for(int i = 1 ; i <= n ; i++){
            for(int j =1 ; j <= n ; j++){
                if(isVisit[i][j] == false){
                    blocks++;
                    dfs(i,j,map[i][j]);
                }
            }
        }
        sb.append(blocks+" ");
        blocks = 0;
        isVisit = new boolean[n+2][n+2];
        for(int i = 1 ; i <= n ; i++){
            for(int j =1 ; j <= n ; j++){
                if(isVisit[i][j] == false){
                    if(map[i][j] == 'B'){
                        blocks++;
                        dfs(i,j,map[i][j]);
                    } else{
                        blocks++;
                        dfs(i,j);
                    }

                }
            }
        }
        sb.append(blocks+"\n");
        System.out.println(sb.toString());

    }

    public static void dfs(int i, int j, char ch){
        if(isVisit[i][j] == false) isVisit[i][j] = true;
        for(int d = 0 ; d < 4 ; d++){
            if(map[i+dr[d]][j+dc[d]] == ch && isVisit[i+dr[d]][j+dc[d]] == false) dfs(i+dr[d],j+dc[d],ch);
        }

    }

    public static void dfs(int i, int j){
        if(isVisit[i][j] == false) isVisit[i][j] = true;
        for(int d = 0 ; d < 4 ; d++){
            if(map[i+dr[d]][j+dc[d]] >'B' && isVisit[i+dr[d]][j+dc[d]] == false) dfs(i+dr[d],j+dc[d]);
        }

    }
}