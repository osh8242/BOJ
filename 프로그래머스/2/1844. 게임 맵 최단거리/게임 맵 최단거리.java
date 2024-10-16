import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    static int[][] move = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static boolean[][] isVisit;
    
    public int solution(int[][] maps) {
        int answer = 0;
        int N = maps.length;
        int M = maps[0].length;
        
        isVisit = new boolean[N][M];        
        Queue<Node> que = new LinkedList<>();
        isVisit[0][0] = true;
        que.offer(new Node(0,0,1));
        
        while(!que.isEmpty()) {
            Node current = que.poll();
            if(current.n == N-1 && current.m == M-1) {
                answer = current.d;
                break;
            }
            for(int i = 0 ; i < 4 ; i++) {
                int n = current.n + move[i][0];
                int m = current.m + move[i][1];
                if(inBound(n, m, N, M) && !isVisit[n][m] && maps[n][m] == 1) {
                    isVisit[n][m] = true;
                    que.offer(new Node(n, m, current.d + 1));
                }
            }

        }
        
        return answer == 0 ? -1 : answer;
    }
    
    boolean inBound(int n, int m, int N, int M) {
        return n >= 0 && n < N && m >=0 && m < M;
    }
}

class Node {
    int n;
    int m;
    int d;
    public Node (int n, int m, int d) {
        this.n = n;
        this.m = m;
        this.d = d;
    }
}