import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static class Node{
        int x;
        int y;
        int distance;
        Node (int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    static boolean[][] visitable;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<Node> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visitable = new boolean[n+2][m+2];
        map = new int[n+2][m+2];
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= m ; j++){
                char temp = st.nextToken().charAt(0);
                switch (temp){
                    case '2' : que.add(new Node(i,j,0)); break;
                    case '1' : visitable[i][j] = true;
                }
            }
        }
        bfs();
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(!visitable[i][j]) sb.append(map[i][j]+" ");
                else sb.append(-1+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void bfs(){
        while(!que.isEmpty()){
            Node node = que.poll();
            map[node.x][node.y] = node.distance;
            for(int i = 0 ; i < 4 ; i++){
                if(visitable[node.x+dx[i]][node.y+dy[i]]){
                    visitable[node.x+dx[i]][node.y+dy[i]] = false;
                    que.add(new Node(node.x+dx[i], node.y+dy[i], node.distance+1));
                }
            }

        }
    }

}
