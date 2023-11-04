import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] lectures;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lectures = new int[N];
        st = new StringTokenizer(br.readLine());
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, lectures[i]);
            end += lectures[i];
        }

        while (start <= end) {
            int middle = start + (end - start) / 2;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (sum + lectures[i] > middle) {
                    count++;
                    sum = 0;
                }
                sum += lectures[i];
            }
            if (sum != 0) count++;
            if (count > M) start = middle + 1;
            else end = middle - 1;
        }
        System.out.println(start);
    }
}
