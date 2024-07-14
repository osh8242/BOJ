import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static List<Integer>[] graph;
    private static int[] pastures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        pastures = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        revegetate(1);
        for (int i = 1; i <= N; i++) {
            sb.append(pastures[i]);
        }
        System.out.println(sb.toString());

    }

    private static boolean revegetate(int pasture) {
        if (pasture > N) {
            return true;
        }

        for (int type = 1; type <= 4; type++) {
            if (canPlant(pasture, type)) {
                pastures[pasture] = type;
                if (revegetate(pasture + 1)) {
                    return true;
                }
                pastures[pasture] = 0;  // Backtrack
            }
        }

        return false;
    }

    private static boolean canPlant(int pasture, int type) {
        for (int neighbor : graph[pasture]) {
            if (pastures[neighbor] == type) {
                return false;
            }
        }
        return true;
    }
}
