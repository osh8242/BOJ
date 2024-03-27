import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, W;
    static int[] time, indegree;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            time = new int[N + 1];
            indegree = new int[N + 1];
            graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X].add(Y);
                indegree[Y]++;
            }
            W = Integer.parseInt(br.readLine());
            sb.append(topologicalSort(W)).append("\n");
        }
        System.out.println(sb);
    }

    static int topologicalSort(int W) {
        int[] result = new int[N + 1];
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                que.offer(i);
                result[i] += time[i];
            }
        }
        while (!que.isEmpty()) {
            int current = que.poll();
            for (int next : graph[current]) {
                result[next] = Math.max(result[next], result[current] + time[next]);
                indegree[next]--;
                if (indegree[next] == 0) que.offer(next);
            }
        }
        return result[W];
    }

}