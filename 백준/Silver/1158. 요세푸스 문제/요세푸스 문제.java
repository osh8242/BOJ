import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int idx = 0;
        for (int removed = 0; removed < N; removed++) {
            idx = (idx + K - 1) % circle.size();
            sb.append(circle.remove(idx));
            if (removed != N - 1) sb.append(", ");
        }
        sb.append('>');
        System.out.print(sb.toString());
    }
}
