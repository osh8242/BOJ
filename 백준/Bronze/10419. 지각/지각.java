import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int d = Integer.parseInt(br.readLine());
            sb.append(binarySearch(d)).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int d) {
        int min = 0;
        int max = d;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canLate(d, mid)) min = mid + 1;
            else max = mid - 1;
        }
        return max;
    }

    static boolean canLate(int d, int t) {
        return t + t * t <= d;
    }

}