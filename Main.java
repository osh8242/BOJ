import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] map;
    public static boolean[][] isVisit;
    public static int[] dr = {1, 0, 0};
    public static int[] dc = {0, 1, -1};
    public static Queue<int[]> que;
    public static int n, m, maxSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+2][m+2];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= m ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        isVisit = new boolean[n+2][m+2];
        que = new LinkedList<>();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                System.out.println("\n방문점 : "+i+","+j);
                isVisit[i][j] = true;
                que.add(new int[]{i,j,1,0,0});
                while(que.size() != 0){
                    int[] temp = que.poll();
                    bfs(temp[0],temp[1],temp[2],temp[3],temp[4]);
                }
            }
        }
        System.out.println(maxSum);

    }

    public static void bfs(int i , int j , int depth, int sum, int moveIndex){
        sum += map[i][j];
        switch (depth){
            case 2:
                switch (moveIndex){

                }
            case 1:
            case 3:
                depth++;
                for(int index = 0 ; index < 3 ; index++){
                    if(map[i+dr[index]][j+dc[index]] > 0 && !isVisit[i+dr[index]][j+dc[index]]){
                        switch (moveIndex){
                            case 0 -> {
                                que.add(new int[]{i+dr[index], j+dc[index], depth, sum, index});
                            }
                            case 1 -> {
                                if(index == 2) continue;
                                que.add(new int[]{i+dr[index], j+dc[index], depth, sum, index});
                            }
                            case 2 -> {
                                if(index == 1) continue;
                                que.add(new int[]{i+dr[index], j+dc[index], depth, sum, index});
                            }
                        }

                    }
                } break;
            case 4:
                if(maxSum < sum) maxSum = sum;
                System.out.println("점수 "+maxSum + " / 종료점 " +i+","+ j );
                return;

        }


        if(depth==2){

        }


    }

}
