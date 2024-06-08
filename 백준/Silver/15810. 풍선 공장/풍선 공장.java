import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(input[i]);
        }
        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * M;
        long result = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            boolean isPossible = isPossible(mid);
            if (isPossible) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    static boolean isPossible(long time) {
        long count = 0;
        for (int i = 0; i < N; i++) {
            count += time / times[i];
            if(count >= M) return true;
        }
        return false;
    }

}
