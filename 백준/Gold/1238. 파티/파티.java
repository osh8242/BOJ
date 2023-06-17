import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int n,m,x;
    static class Node implements Comparable<Node>{

        int index;
        int destination;
        int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public void setDestination(int destination) {
            this.destination = destination;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++) graph[i] = new ArrayList<>();
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            graph[index].add(new Node(index, time));
            graph[index].get(graph[index].size()-1).setDestination(destination);
        }
        int maxTime = Integer.MIN_VALUE;
        for(int i = 1 ; i <= n ; i++){
            int totalTime = 0;
            totalTime += dijkstra(i,x);
            totalTime += dijkstra(x,i);
            if(maxTime < totalTime) maxTime = totalTime;
        }
        System.out.println(maxTime);


    }

    static int dijkstra(int start, int goal){

        int[] times = new int[n+1];
        for(int i = 0 ; i <= n ; i++) times[i] = Integer.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        times[start] = 0;
        while(!pq.isEmpty()){
            Node currentNode = pq.poll();
            int index = currentNode.index;
            int time = currentNode.time;
            if(time > times[index]) continue;
            for(Node node : graph[index]){
                int newPathTime = node.time + time;
                if(newPathTime < times[node.destination]){
                    times[node.destination] = newPathTime;
                    pq.add(new Node(node.destination, newPathTime));
                }
            }
        }

        return times[goal];
    }


}
