import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] cities;

    private void solution() throws IOException {
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int status = Integer.parseInt(st.nextToken());
                if (status == 1) union(i, j);
            }
        }
        boolean isConnected = true;
        st = new StringTokenizer(br.readLine());
        int parent = getParent(Integer.parseInt(st.nextToken()));
        while (st.hasMoreTokens()) {
            if (parent != getParent(Integer.parseInt(st.nextToken()))) {
                isConnected = false;
                break;
            }
        }
        System.out.println(isConnected ? "YES" : "NO");
    }

    void union(int i, int j) {
        i = getParent(i);
        j = getParent(j);
        if (i != j) cities[j] = i;
    }

    int getParent(int i) {
        return cities[i] == i ? i : (cities[i] = getParent(cities[i]));
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cities = new int[N + 1];
        for (int i = 1; i <= N; i++) cities[i] = i;

        new Main().solution();
    }

}
