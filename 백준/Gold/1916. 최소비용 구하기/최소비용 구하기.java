import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static class Node implements Comparable<Node> {
        public int index;
        public int price;

        public Node(int index, int price) {
            this.index = index;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return this.price - o.price;
        }
    }

    static ArrayList<Node>[] paths;
    static int[] prices;
    static int n, startNode, endNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paths = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) paths[i] = new ArrayList<>();
        prices = new int[n + 1];
        Arrays.fill(prices, Integer.MAX_VALUE);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            paths[start].add(new Node(end, price));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        dijkstra(startNode);

        System.out.println(prices[endNode]);
    }

    static void dijkstra(int startNode) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));
        prices[startNode] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int currentIndex = node.index;
            int currentPrice = node.price;

            if (currentPrice > prices[currentIndex]) continue;

            ArrayList<Node> cNodes = paths[currentIndex];
            for (Node cNode : cNodes) {
                int newIndex = cNode.index;
                int newPrice = currentPrice + cNode.price;
                if (newPrice < prices[newIndex]) {
                    prices[newIndex] = newPrice;
                    pq.add(new Node(newIndex, newPrice));
                }
            }
        }
    }
}
