import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m, k;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Integer>[] distances = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) distances[i] = new PriorityQueue<>(k, Collections.reverseOrder());
        distances[1].offer(0);

        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            for (Node next : graph[current.index]) {
                int newCost = current.cost + next.cost;
                if (distances[next.index].size() < k) {
                    distances[next.index].offer(newCost);
                    pq.add(new Node(next.index, newCost));
                } else if (distances[next.index].peek() > newCost) {
                    distances[next.index].poll();
                    distances[next.index].add(newCost);
                    pq.add(new Node(next.index, newCost));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(distances[i].size() == k ? distances[i].peek() : -1).append("\n");
        }
        System.out.println(sb);

    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}