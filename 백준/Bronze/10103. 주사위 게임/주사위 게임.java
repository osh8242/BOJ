import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int chang = 100;
        int sang = 100;
        for (int T = 1; T <= n; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (c == s) continue;
            else if (c > s) sang -= c;
            else if (c < s) chang -= s;
        }
        System.out.println(chang+"\n"+sang);

    }

}
