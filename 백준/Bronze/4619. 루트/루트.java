import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if (B == 0 && N == 0) break;
            sb.append(getA(B, N)).append("\n");
        }
        System.out.println(sb);
    }

    static int getA(int B, int N) {
        int A = 1;
        int result = A;
        int minDiff = B;
        boolean found = false;
        while (!found) {
            int pow = A;
            for (int i = 1; i < N; i++) pow *= A;
            if (Math.abs(B - pow) < minDiff) {
                result = A;
                minDiff = Math.abs(B - pow);
            }
            else found = true;
            A++;
        }
        return result;
    }
}
