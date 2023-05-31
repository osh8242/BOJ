import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        public int index;
        public int weight;
        public Node(int index, int weight){
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
    static int v, e, k; //정점의 수, 간선의 수, 시작정점
    static ArrayList<Node>[] paths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        v = Integer.parseInt(st.nextToken());
        paths = new ArrayList[v+1];
        for(int i = 1 ; i <= v ; i++) paths[i] = new ArrayList<>();
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        for(int line = 1 ; line <= e ; line++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            paths[u].add(new Node(v,w));
        }

        int[] minWeights = dijkstra();
        for(int i = 1 ; i <= v ; i++){
            if(minWeights[i]==Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(minWeights[i] + "\n");
        }
        System.out.println(sb);

    }//main(){}

    static int[] dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] minWeights = new int[v+1];
        for(int i = 1 ; i <= v ; i++) minWeights[i] = Integer.MAX_VALUE;
        pq.add(new Node(k,0));
        minWeights[k] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int currentIndex = node.index;
            int currentWeight = node.weight;
            if(minWeights[currentIndex] < currentWeight) continue;

            ArrayList<Node> cNodes = paths[currentIndex];
            for(Node cNode : cNodes){
                int newIndex = cNode.index;
                int newWeight = minWeights[currentIndex]+cNode.weight;
                if(minWeights[newIndex] > newWeight){
                    minWeights[newIndex] = newWeight;
                    pq.add(new Node(newIndex, newWeight));
                }
            }
        }

        return minWeights;
    }

}//class Main{}
