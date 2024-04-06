import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        indegree = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            indegree[end]++;
            graph[start].add(end);
        }
        Queue<Integer> que = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) que.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            int current = que.poll();
            sb.append(current).append(" ");
            for (int next : graph[current]) {
                indegree[next]--;
                if (indegree[next] == 0) que.offer(next);
            }
        }
        System.out.println(sb);
    }
}
