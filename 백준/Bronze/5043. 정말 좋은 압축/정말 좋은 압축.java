import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        long maxCodes = (1L << (b + 1)) - 1;

        System.out.println(N <= maxCodes ? "yes" : "no");
    }
}
