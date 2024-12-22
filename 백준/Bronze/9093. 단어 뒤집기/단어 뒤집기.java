import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                String input = st.nextToken();
                for (int i = input.length() - 1; i >= 0; i--) {
                    sb.append(input.charAt(i));
                }
                if (st.hasMoreTokens()) sb.append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

}
