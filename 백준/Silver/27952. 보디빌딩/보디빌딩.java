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

        int weight = 0;
        int routine = 0;
        boolean isExhausted = false;
        for (int i = 0; i < N; i++) {
            weight += B[i];
            if (weight < A[i]) {
                int gap = A[i] - weight;
                int cancelCount = gap / X;
                if (gap % X != 0) cancelCount++;
                if (cancelCount > routine) {
                    isExhausted = true;
                    break;
                }
                routine -= cancelCount;
                weight += cancelCount * X;
            }
            int count = (weight - A[i]) / X;
            routine += count;
            weight -= count * X;
        }
        System.out.println(isExhausted ? -1 : routine);
    }
}
