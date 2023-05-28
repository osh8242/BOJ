import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static class Node implements Comparable<Node>{
        public int index;
        public int distance;
        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    static ArrayList<Node>[] paths;
    static int n,n1,n2;

    static final int maximum = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        paths = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++) paths[i] = new ArrayList<>();
        int e = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < e ; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            paths[node1].add(new Node(node2, distance));
            paths[node2].add(new Node(node1, distance));
        }
        st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());

        int commonPath = dijkstra(n1,n2);
        int startToN1 = dijkstra(1,n1);
        int startToN2 = dijkstra(1,n2);
        int n1ToN = dijkstra(n1,n);
        int n2ToN = dijkstra(n2,n);

        int path1 = startToN1 + commonPath + n2ToN;
        int path2 = startToN2 + commonPath + n1ToN;
        if(path1 >= maximum && path2 >= maximum){
            System.out.println(-1);
        } else {
            System.out.println(Math.min(path1,path2));
        }



    }

    static int dijkstra(int startIndex, int endIndex){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dArr = new int[n+1];
        for(int i = 1 ; i <= n ; i++) dArr[i] = maximum;

        pq.add(new Node(startIndex, 0));
        dArr[startIndex] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int currentIndex = node.index;
            int currentDistance = node.distance;

            if(dArr[currentIndex] < currentDistance) continue;

            ArrayList<Node> cNodes = paths[currentIndex];
            for(Node cNode : cNodes){
                if(dArr[cNode.index] > dArr[currentIndex] + cNode.distance){
                    dArr[cNode.index] = dArr[currentIndex] + cNode.distance;
                    pq.add(new Node(cNode.index, dArr[cNode.index]));
                }
            }

        }
        return dArr[endIndex];
    }

}
