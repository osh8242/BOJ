import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static Character[][] map;
    static int row, col, maxCount;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static boolean[] isVisit = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new Character[row + 2][col + 2];
        maxCount = 0;
        for (int i = 1; i <= row; i++) {
            String line = br.readLine();
            for(int j = 1 ; j <= col ; j ++){
                map[i][j] = line.charAt(j-1);
            }
        }
        isVisit[map[1][1]-65] = true;
        dfs(1,1,1);
        System.out.println(maxCount);

    }

    static void dfs(int x, int y, int count){
        if(count > maxCount) maxCount = count;
        for(int i = 0 ; i < 4 ; i++){
            int newX = x+dr[i];
            int newY = y+dc[i];
            if(map[newX][newY] != null && !isVisit[map[newX][newY]-65]){
                isVisit[map[newX][newY]-65] = true;
                dfs(newX,newY,count+1);
                isVisit[map[newX][newY]-65] = false;
            }
        }
    }

}
