import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        long weight = 0;
        long count = 0;
        boolean isExhausted = false;
        for (int i = 0; i < N; i++) {
            weight += B[i];
            if (weight < A[i]) {
                long gap = A[i] - weight;
                long cancelCount = gap / X;
                if (gap % X != 0) cancelCount++;
                if (cancelCount > count) {
                    isExhausted = true;
                    break;
                }
                count -= cancelCount;
                weight += cancelCount * X;
            } else {
                long temp = (weight - A[i]) / X;
                count += temp;
                weight -= temp * X;
            }
        }
        System.out.println(isExhausted ? -1 : count);
    }
}
