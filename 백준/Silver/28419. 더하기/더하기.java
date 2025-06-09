import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sumOdd = 0, sumEven = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if ((i & 1) == 1) sumOdd += a;
            else sumEven += a;
        }
        long D = sumEven - sumOdd;
        if (D >= 0) {
            System.out.println(D);
        } else {
            if (N >= 4) {
                System.out.println(-D);
            } else {
                System.out.println(-1);
            }
        }
    }
}
