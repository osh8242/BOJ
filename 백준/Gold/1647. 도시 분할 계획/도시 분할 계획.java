import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        PriorityQueue<Node> que = new PriorityQueue<Node>();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            que.offer(new Node(start, end, cost));
        }
        int costSum = 0;
        int maxCost = 0;
        while (!que.isEmpty()) {
            Node node = que.poll();
            if (getParent(node.current) != getParent(node.next)) {
                union(node.current, node.next);
                costSum += node.cost;
                maxCost = node.cost;
            }
        }
        System.out.println(costSum - maxCost);

    }

    static int getParent(int index) {
        return index == parent[index] ? index : (parent[index] = getParent(parent[index]));
    }

    static void union(int x, int y) {
        x = getParent(x);
        y = getParent(y);
        if (x != y) parent[y] = getParent(x);
    }

    static class Node implements Comparable<Node> {
        int current;
        int next;
        int cost;

        public Node(int current, int next, int cost) {
            this.current = current;
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
