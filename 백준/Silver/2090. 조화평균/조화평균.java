import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long lcm = 1;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            lcm *= list[i];
        }
        long parent = lcm;
        long child = 0;
        for (int i : list) child += lcm / i;

        long gcd = getGCD(parent, child);
        parent /= gcd;
        child /= gcd;

        sb.append(parent).append("/").append(child);
        System.out.println(sb);
    }

    static long getGCD(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
