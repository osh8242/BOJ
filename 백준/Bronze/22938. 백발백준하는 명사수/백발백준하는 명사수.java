import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long r1 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());
        long r2 = Long.parseLong(st.nextToken());
        boolean overlap = square(sub(x1, x2)) + square(sub(y1, y2)) < square(add(r1, r2));
        System.out.println(overlap ? "YES" : "NO");
    }

    static long add(long x, long y) {
        return x + y;
    }

    static long sub(long x, long y) {
        return x - y;
    }

    static long square(long x) {
        return x * x;
    }
}
