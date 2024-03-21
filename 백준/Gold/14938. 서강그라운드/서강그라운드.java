import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[] item;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }
        item = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }
        while(R-->0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[i].add(new Node(j,l));
            graph[j].add(new Node(i,l));
        }
        int answer = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N ; i++){
            answer = Math.max(answer, daijkstra(i));
        }
        System.out.println(answer);
    }

    static int daijkstra(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> que = new PriorityQueue<>();
        dist[start] = 0;
        que.offer(new Node(start, 0));
        while(!que.isEmpty()){
            Node node = que.poll();
            int i = node.idx;
            int d = node.dist;
            ArrayList<Node> list = graph[i];
            for(Node next : list){
                int nextDist = next.dist + d;
                if(nextDist < dist[next.idx]){
                    dist[next.idx] = nextDist;
                    que.offer(new Node(next.idx, nextDist));
                }
            }
        }
        int result = 0;
        for(int i = 1 ; i <= N ; i++){
            if(dist[i] <= M) result += item[i];
        }
        return result;
    }

    static class Node implements Comparable<Node>{
        private int idx;
        private int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.dist, o.dist);
        }
    }
}
