import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Node {
        private int index;
        private int num;

        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }

    static Deque<Node> deque = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static int N, L;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            addNode(i, Integer.parseInt(st.nextToken()));
        }
        System.out.println(sb);

    }

    static void addNode(int index, int num) {
        while (!deque.isEmpty() && deque.getLast().num > num) {
            deque.removeLast();
        }
        deque.addLast(new Node(index, num));
        while (deque.getFirst().index <= index - L) {
            deque.removeFirst();
        }
        sb.append(deque.getFirst().num).append(" ");
    }

}
