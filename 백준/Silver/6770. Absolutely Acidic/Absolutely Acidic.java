import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] records = new int[1001];
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int record = Integer.parseInt(br.readLine());
            records[record]++;
        }

        Queue<Node> que = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i < 1001; i++) {
            if (records[i] > 0) que.add(new Node(i, records[i]));
        }

        Node first = que.poll();
        int secondCount = que.peek().count;
        while (!que.isEmpty() && secondCount == que.peek().count) {
            Node second = que.poll();
            answer = Math.max(answer, Math.abs(first.value - second.value));
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    static class Node implements Comparable<Node> {
        int value;
        int count;

        Node(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count == o.count ? this.value - o.value : this.count - o.count;
        }
    }

}

