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
    static int N;
    static int[] buildTime;
    static ArrayList<Integer>[] data;
    static int[] degrees;


    private void solution() throws IOException {
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            buildTime[i] = time;
            int num = 0;
            while ((num = Integer.parseInt(st.nextToken())) != -1) {
                data[num].add(i);
                degrees[i]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degrees[i] == 0) que.offer(i);
        }
        int[] answerTime = new int[N + 1];
        while (!que.isEmpty()) {
            int current = que.poll();
            for (int next : data[current]) {
                degrees[next]--;
                answerTime[next] = Math.max(answerTime[next], answerTime[current] + buildTime[current]);
                if (degrees[next] == 0) que.offer(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(answerTime[i] + buildTime[i]).append("\n");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        data = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) data[i] = new ArrayList<>();
        degrees = new int[N + 1];
        buildTime = new int[N + 1];

        new Main().solution();
    }

}
