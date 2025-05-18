import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        if (w < l || w > 26 * l) {
            System.out.println("impossible");
            return;
        }

        StringBuilder sb = new StringBuilder();
        int remaining = l;
        int sum = w;
        for (int i = 0; i < l; i++) {
            remaining--;
            int low = sum - remaining * 26;
            int x = Math.max(1, low);
            if (x > 26) x = 26;
            sb.append((char)('a' + x - 1));
            sum -= x;
        }

        System.out.println(sb);
    }
}
