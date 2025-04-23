import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (st.hasMoreTokens()) {
            int v = Integer.parseInt(st.nextToken());
            if (v < min) min = v;
            if (v > max) max = v;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(' ').append(max);
        System.out.println(sb.toString());
    }
}
