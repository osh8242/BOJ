import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long K = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());


        if (N == 1) {
            System.out.println(-1);
            return;
        }

        long num = N * K;
        long den = N - 1;

        long X = (num + den - 1) / den;

        System.out.println(X);
    }
}
