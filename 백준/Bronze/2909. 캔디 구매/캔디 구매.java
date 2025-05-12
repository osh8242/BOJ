import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long C = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long D = 1;
        for (int i = 0; i < K; i++) {
            D *= 10;
        }
        long rem = C % D;
        if (rem * 2 >= D) {
            C = C - rem + D;
        } else {
            C = C - rem;
        }
        System.out.println(C);
    }
}
