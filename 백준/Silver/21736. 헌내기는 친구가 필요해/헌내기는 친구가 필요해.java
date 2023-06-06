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
        Node (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static boolean[][] visitable;
    static char[][] map;
    static int count = 0;
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
        map = new char[n+2][m+2];
        for(int i = 1 ; i <= n ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < m ; j++){
                char temp = str.charAt(j);
                map[i][j+1] = temp;
                if(temp=='O' || temp=='P') visitable[i][j+1] = true;
                if(temp=='I') que.add(new Node(i,j+1));
            }
        }
        bfs();
        if(count != 0) System.out.println(count);
        else System.out.println("TT");

    }

    static void bfs(){
        while(!que.isEmpty()){
            Node node = que.poll();
            if(map[node.x][node.y] == 'P') count++;
            for(int i = 0 ; i < 4 ; i++){
                if(visitable[node.x+dx[i]][node.y+dy[i]]){
                    visitable[node.x+dx[i]][node.y+dy[i]] = false;
                    que.add(new Node(node.x+dx[i], node.y+dy[i]));
                }
            }

        }
    }

}
