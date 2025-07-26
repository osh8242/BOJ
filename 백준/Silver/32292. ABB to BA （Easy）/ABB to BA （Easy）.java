import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            StringBuilder sb = new StringBuilder(br.readLine().trim());
            int idx;
            while ((idx = sb.indexOf("ABB")) != -1) {
                sb.setCharAt(idx, 'B');
                sb.setCharAt(idx+1, 'A');
                sb.deleteCharAt(idx+2);
            }
            System.out.println(sb);
        }
    }
}
