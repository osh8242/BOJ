import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer>[] reverseGraph;
    static int N;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            reverseGraph[b].add(a);
        }

        int candidate = -1;
        for (int i = 1; i <= N; i++) {
            if (canReachAllNodes(i)) {
                candidate = i;
                break;
            }
        }

        bw.write(Integer.toString(candidate));
        bw.flush();
    }

    static boolean canReachAllNodes(int start) {
        visited = new boolean[N + 1];
        dfs(start);
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : reverseGraph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
