import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static ArrayList<Integer>[] data;
    static int[] degrees;

    private void solution() throws IOException {
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int behind = Integer.parseInt(st.nextToken());
            data[front].add(behind);
            degrees[behind]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degrees[i] == 0) que.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            int current = que.poll();
            sb.append(current).append(" ");
            for (int next : data[current]) {
                degrees[next]--;
                if (degrees[next] == 0) que.offer(next);
            }
        }
        System.out.println(sb);

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) data[i] = new ArrayList<>();
        degrees = new int[N + 1];

        new Main().solution();
    }

}
