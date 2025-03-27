import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long result = 1;
        for (int i = a; i <= b; i++) {
            long sum = (long) i * (i + 1) / 2;
            result = (result * sum) % 14579;
        }
        System.out.println(result);
    }
}
