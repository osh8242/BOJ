import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Ratio>[] relation;
    static boolean[] isVisited;
    static long[] mass;
    static int N;
    static long lcm = 1;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        relation = new ArrayList[N];
        for (int i = 0; i < N; i++) relation[i] = new ArrayList<>();
        mass = new long[N];
        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            relation[a].add(new Ratio(b, p, q));
            relation[b].add(new Ratio(a, q, p));
            lcm *= (p * q) / getGcd(p, q);
        }
        isVisited = new boolean[N];
        mass[0] = lcm;
        dfs(0);

        long gcd = lcm;
        for (int i = 1; i < N; i++) {
            gcd = getGcd(gcd, mass[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(mass[i] / gcd).append(" ");
        }
        System.out.println(sb);
    }

    private long getGcd(long max, long min) {
        if (min == 0) return max;
        return getGcd(min, max % min);
    }

    private void dfs(int index) {
        isVisited[index] = true;
        for (Ratio r : relation[index]) {
            if (!isVisited[r.other]) {
                mass[r.other] = mass[index] * r.q / r.p;
                dfs(r.other);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private static class Ratio {
        private int other;
        private int p;
        private int q;

        public Ratio(int other, int p, int q) {
            this.other = other;
            this.p = p;
            this.q = q;
        }
    }

}
