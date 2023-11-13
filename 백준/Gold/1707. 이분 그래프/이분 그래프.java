import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] isVisited;
    static Boolean[] marks;
    static ArrayList<Integer>[] map;
    static boolean isBipartite;
    static StringBuilder sb = new StringBuilder();

    private void solution() throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            isVisited = new boolean[K + 1];
            marks = new Boolean[K + 1];
            map = new ArrayList[K + 1];
            for (int i = 1; i <= K; i++) map[i] = new ArrayList<>();
            for (int i = 1; i <= V; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                map[start].add(end);
                map[end].add(start);
            }
            isBipartite = true;
            for (int i = 1; i <= K; i++) {
                if (!isVisited[i]) dfs(i, true);
            }
            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);

    }

    void dfs(int current, boolean mark) {
        isVisited[current] = true;
        marks[current] = mark;
        for (int next : map[current]) {
            if (!isVisited[next]) {
                marks[next] = !marks[current];
                dfs(next, marks[next]);
            } else if (marks[next] == marks[current]) {
                isBipartite = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}
