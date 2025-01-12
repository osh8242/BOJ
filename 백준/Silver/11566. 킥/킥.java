import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] reality = new int[N];
        for (int i = 0; i < N; i++) {
            reality[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] dream = new int[M];
        for (int i = 0; i < M; i++) {
            dream[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> depths = new ArrayList<>();
        for (int depth = 0; N + depth * (N - 1) <= M; depth++) {
            int d = 0;
            while (M - d >= N + depth * (N - 1)) {
                if (reality[0] == dream[d]) {
                    if (isDream(reality, dream, depth, d)) {
                        depths.add(depth);
                        break;
                    }
                }
                d++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!depths.isEmpty()) {
            sb.append(depths.get(0)).append(" ").append(depths.get(depths.size() - 1));
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }

    static boolean isDream(int[] reality, int[] dream, int depth, int d) {
        for (int i = 1; i < reality.length; i++) {
            if (reality[i] != dream[d + (depth + 1) * i]) {
                return false;
            }
        }
        return true;
    }
}
