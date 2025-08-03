import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String A = br.readLine().trim();
        String B = br.readLine().trim();
        int ans = 0;
        boolean inSegment = false;
        for (int i = 0; i < N; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (!inSegment) {
                    ans++;
                    inSegment = true;
                }
            } else {
                inSegment = false;
            }
        }
        System.out.println(ans);
    }
}
