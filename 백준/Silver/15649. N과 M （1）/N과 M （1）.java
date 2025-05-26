import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] used;
    static int[] perm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N + 1];
        perm = new int[M];
        StringBuilder sb = new StringBuilder();
        dfs(0, sb);
        System.out.print(sb.toString());
    }

    static void dfs(int depth, StringBuilder sb) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(perm[i]);
                if (i < M - 1) sb.append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int num = 1; num <= N; num++) {
            if (!used[num]) {
                used[num] = true;
                perm[depth] = num;
                dfs(depth + 1, sb);
                used[num] = false;
            }
        }
    }
}