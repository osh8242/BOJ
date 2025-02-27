import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            getTime(T, S, I, C);
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void getTime(int T, int S, int I, int C) {
        if (inBound(T, S, I, C)) {
            if (T <= S) min = Math.min(min, S - T);
            else {
                int t = binarySearch(T, S, I, C);
                min = Math.min(min, t);
            }
        }
    }

    static boolean inBound(int T, int S, int I, int C) {
        return T <= S + I * (C - 1);
    }

    static int binarySearch(int T, int S, int I, int C) {
        int low = 0;
        int high = C - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int t = S + mid * I;
            if (T == t) {
                return 0;
            } else if (t > T) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return S + low * I - T;
    }

}
