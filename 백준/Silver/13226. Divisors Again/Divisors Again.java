import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int max = -1;

            for (int value = L; value <= U; value++) {
                int count = 0;
                for (int divisor = 1; divisor <= Math.sqrt(value); divisor++) {
                    if (value % divisor == 0) {
                        count++;
                        if (divisor * divisor != value) count++;
                    }
                }
                if (max < count) max = count;
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
