import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int minKebin = Integer.MAX_VALUE;
    static int minIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int line = 1; line <= m; line++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int v = 1; v <= N; v++) {
            int kebin = bfs(v);
            if (kebin < minKebin) {
                minKebin = kebin;
                minIndex = v;
            }
        }
        System.out.println(minIndex);
    }

    static int bfs(int v) {
        int kebin = 0;
        Queue<Integer> que = new LinkedList<>();
        int[] isVisit = new int[N + 1];
        que.add(v);
        while (!que.isEmpty()) {
            int current = que.poll();
            for (int next : graph[current]) {
                if (isVisit[next] != 0) continue;
                isVisit[next] = isVisit[current] + 1;
                kebin += isVisit[next];
                que.add(next);
            }
        }
        return kebin;
    }

}