import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static int n;
    static class Node implements Comparable<Node>{
        public int index;
        public int price;
        public Node(int index, int price){
            this.index = index;
            this.price = price;
        }
        @Override
        public int compareTo(Node o) {
            return this.price - o.price;
        }
    }
    static class History{
        public int totalPrice;
        public ArrayList<Integer> path;
        public History(){
            this.totalPrice = Integer.MAX_VALUE;
            this.path = new ArrayList<>();
        }
        public void updateHistory(Node newNode, History prevHistory){
            this.totalPrice = newNode.price + prevHistory.totalPrice;
            this.path = (ArrayList<Integer>) prevHistory.path.clone();
            this.path.add(newNode.index);
        }

    }

    static ArrayList<Node>[] paths;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paths = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++) paths[i] = new ArrayList<>();

        int m = Integer.parseInt(br.readLine());
        while(m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            paths[start].add(new Node(end, price));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());

        History answer = dijkstra(startIndex, endIndex);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.totalPrice+"\n");
        sb.append(answer.path.size()+"\n");
        for(int index : answer.path){
            sb.append(index+" ");
        }
        System.out.println(sb);

    }

    static History dijkstra(int startIndex, int endIndex){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        History[] histories = new History[n+1];
        for(int i = 1 ; i <= n ; i++) histories[i] = new History();

        pq.add(new Node(startIndex, 0));
        histories[startIndex].totalPrice = 0;
        histories[startIndex].path.add(startIndex);

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int currentIndex = node.index;
            int currentPrice = node.price;

            if(currentPrice > histories[currentIndex].totalPrice) continue;

            ArrayList<Node> cNodes = paths[currentIndex];
            for(Node cNode : cNodes){
                int newIndex = cNode.index;
                int newPrice = histories[currentIndex].totalPrice + cNode.price;
                if(histories[newIndex].totalPrice > newPrice){
                    histories[newIndex].updateHistory(cNode, histories[currentIndex]);
                    pq.add(new Node(newIndex, newPrice));
                }
            }
        }

        return histories[endIndex];
    }


}
