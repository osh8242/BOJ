import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] assigned = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            assigned[i] = Integer.parseInt(st.nextToken());
        }

        if (assigned[m] == m) {
            System.out.println(0);
            return;
        }

        int count = 0;
        boolean[] visited = new boolean[n + 1];
        int cur = m;
        while (!visited[cur]) {
            visited[cur] = true;
            cur = assigned[cur];
            count++;
        }
        System.out.println(count);
    }
}
