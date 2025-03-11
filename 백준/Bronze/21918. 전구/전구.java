import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        boolean[] bulbs = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            bulbs[i] = Integer.parseInt(st.nextToken()) == 1;
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    one(bulbs, a, b);
                    break;
                case 2:
                    two(bulbs, a, b);
                    break;
                case 3:
                    three(bulbs, a, b);
                    break;
                case 4:
                    four(bulbs, a, b);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(bulbs[i] ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }

    static void one(boolean[] bulbs, int i, int x) {
        bulbs[i] = x == 1;
    }

    static void two(boolean[] bulbs, int l, int r) {
        for (int i = l; i <= r; i++) {
            bulbs[i] = !bulbs[i];
        }
    }

    static void three(boolean[] bulbs, int l, int r) {
        for (int i = l; i <= r; i++) {
            bulbs[i] = false;
        }
    }

    static void four(boolean[] bulbs, int l, int r) {
        for (int i = l; i <= r; i++) {
            bulbs[i] = true;
        }
    }
}
