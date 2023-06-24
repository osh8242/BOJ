import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m,minDistancce;

    static class Node {
        int x;
        int y;
        boolean isBreak;
        int distance;

        public Node(int x, int y, int distance, boolean isBreak) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.isBreak = isBreak;
        }

    }

    static boolean[][] isWall, isVisitAfterWall, isVisitBeforeWall;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isWall = new boolean[n+1][m+1];
        isVisitBeforeWall = new boolean[n+1][m+1];
        isVisitAfterWall = new boolean[n+1][m+1];
        minDistancce = -1;
        for(int i = 1 ; i <= n ; i++){
            String line = br.readLine();
            for(int j = 0 ; j < m ; j++){
                if(line.charAt(j) == '1') isWall[i][j+1] = true;
            }
        }
        bfs();
        System.out.println(minDistancce);

    }

    static void bfs(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1,1,1, false));
        isVisitBeforeWall[1][1] = true;
        while(!que.isEmpty()){
            Node node = que.poll();
            int x = node.x;
            int y = node.y;
            int distance = node.distance;
            if(x==m && y==n){
                if(minDistancce > distance || minDistancce < 0) minDistancce = distance;
                return;
            }
            boolean isBreak = node.isBreak;
            for(int k = 0 ; k < 4 ; k++){
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(nx <= m && ny <= n && nx >= 1 && ny >= 1){
                    if(!isWall[ny][nx]) {
                        if(!isBreak && !isVisitBeforeWall[ny][nx]){
                            isVisitBeforeWall[ny][nx] = true;
                            que.add(new Node(nx,ny,distance+1, isBreak));
                        } else if(isBreak && !isVisitAfterWall[ny][nx]){
                            isVisitAfterWall[ny][nx] = true;
                            que.add(new Node(nx,ny,distance+1, isBreak));
                        }
                    } else if(!isBreak && !isVisitAfterWall[ny][nx]){
                        isVisitAfterWall[ny][nx] = true;
                        que.add(new Node(nx,ny,distance+1,!isBreak));
                    }
                }
            }
        }

    }

}
