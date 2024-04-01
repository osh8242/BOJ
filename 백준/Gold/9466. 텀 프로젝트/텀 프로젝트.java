import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int[] choices;
    static boolean[] isVisited, isTeam;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            R = Integer.parseInt(br.readLine());
            count = 0;
            choices = new int[R];
            isVisited = new boolean[R];
            isTeam = new boolean[R];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < R; i++) {
                choices[i] = Integer.parseInt(st.nextToken()) - 1;
            }
            for (int i = 0; i < R; i++) {
                if (!isVisited[i]) dfs(i);
            }
            sb.append(R - count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int idx) {
        if (isVisited[idx]) return;
        isVisited[idx] = true;
        int next = choices[idx];
        if (!isVisited[next]) dfs(next);
        else if (!isTeam[next]) {
            count++;
            for (int i = next; i != idx; i = choices[i]) {
                count++;
            }
        }
        isTeam[idx] = true;
    }

}
