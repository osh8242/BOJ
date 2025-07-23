import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("0 0")) break;
            StringTokenizer st = new StringTokenizer(line);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] cust = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                cust[i] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            for (int k = 0; k < n; k++) {
                st = new StringTokenizer(br.readLine());
                boolean ok = true;
                for (int i = 0; i < m; i++) {
                    int t = Integer.parseInt(st.nextToken());
                    if (t > cust[i]) {
                        ok = false;
                        for (int j = i+1; j < m; j++) st.nextToken();
                        break;
                    }
                }
                if (ok) ans++;
            }
            System.out.println(ans);
        }
    }
}
