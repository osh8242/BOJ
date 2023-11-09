import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long gcd = findGcd(Math.max(A, B), Math.min(A, B));
        StringBuilder sb = new StringBuilder();
        while (gcd-- > 0) sb.append(1);
        System.out.println(sb);
    }

    long findGcd(long max, Long min) {
        if (max % min == 0) return min;
        return findGcd(min, max % min);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}
