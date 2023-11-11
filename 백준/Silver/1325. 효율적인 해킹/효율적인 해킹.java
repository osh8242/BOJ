import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static ArrayList<Integer>[] map;
    static boolean[] isVisited;
    static int[] depths;

    private void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1];
        isVisited = new boolean[N + 1];
        depths = new int[N + 1];
        for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start].add(end);
        }

        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N + 1];
            bfs(i);
        }

        int maxCount = -1;
        for (int i = 1; i <= N; i++) maxCount = Math.max(depths[i], maxCount);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (depths[i] == maxCount) sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

    void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        isVisited[start] = true;
        que.add(start);
        while (!que.isEmpty()) {
            int index = que.poll();
            for (int next : map[index]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    depths[next]++;
                    que.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}
