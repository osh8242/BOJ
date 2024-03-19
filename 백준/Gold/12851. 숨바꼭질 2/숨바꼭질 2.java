import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] isVisit = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;
        int minCount = Integer.MAX_VALUE;
        Queue<Node> que = new LinkedList<>();
        isVisit[N] = 1;
        que.offer(new Node(N, 1));
        boolean find = false;
        while (!que.isEmpty()) {
            Node node = que.poll();
            int idx = node.idx;
            int count = node.count;
            if (find) {
                if (idx == K)
                    answer++;
                else if (count > minCount) break;
                else continue;
            }
            if (idx == K && !find) {
                find = true;
                minCount = count;
                answer++;
                continue;
            }

            if (inBound(idx + 1) && isVisitable(idx + 1, count)) {
                isVisit[idx + 1] = count + 1;
                que.offer(new Node(idx + 1, count + 1));
            }
            if (inBound(idx - 1) && isVisitable(idx - 1, count)) {
                isVisit[idx - 1] = count + 1;
                que.offer(new Node(idx - 1, count + 1));
            }
            if (inBound(2 * idx) && isVisitable(2 * idx, count)) {
                isVisit[2 * idx] = count + 1;
                que.offer(new Node(2 * idx, count + 1));
            }
        }
        System.out.println(isVisit[K] - 1);
        System.out.println(answer);

    }

    static boolean inBound(int idx) {
        return idx >= 0 && idx < 100001;
    }

    static boolean isVisitable(int idx, int count) {
        return isVisit[idx] == 0 || isVisit[idx] == count + 1;
    }

    static class Node {
        private final int idx;
        private final int count;

        public Node(int idx, int count) {
            this.idx = idx;
            this.count = count;
        }
    }

}
