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
                Node next = new Node(current.n + move[i][0], current.m + move[i][1], current.d + 1);
                if(inBound(next, N, M) && !isVisit[next.n][next.m] && maps[next.n][next.m] == 1) {
                    isVisit[next.n][next.m] = true;
                    que.offer(next);
                }
            }

        }
        
        return answer == 0 ? -1 : answer;
    }
    
    boolean inBound(Node node, int N, int M) {
        return node.n >= 0 && node.n < N && node.m >=0 && node.m < M;
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