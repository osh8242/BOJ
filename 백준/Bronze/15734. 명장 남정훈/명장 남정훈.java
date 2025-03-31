import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        
        int diff = Math.abs(L - R);
        int result = 0;
        
        if (A <= diff) {
            result = 2 * (Math.min(L, R) + A);
        } else {
            int remainder = A - diff;
            result = 2 * (Math.max(L, R) + remainder / 2);
        }
        
        System.out.println(result);
    }
}
