import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisit;
    static int A, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isVisit = new boolean[K+1];

        int answer = -1;
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(A, 0));
        isVisit[A] = true;
        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.index == K) {
                answer = cur.count;
                break;
            }
            int nextIndex = cur.index + 1;
            int count = cur.count + 1;
            if (inBound(nextIndex) && !isVisit[nextIndex]) {
                isVisit[nextIndex] = true;
                que.offer(new Node(nextIndex, count));
            }
            nextIndex = cur.index * 2;
            if (inBound(nextIndex) && !isVisit[nextIndex]) {
                isVisit[nextIndex] = true;
                que.offer(new Node(nextIndex, count));
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }

    static boolean inBound(int n) {
        return n <= K;
    }

}

class Node {
    int index;
    int count;

    public Node(int index, int count) {
        this.index = index;
        this.count = count;
    }
}
