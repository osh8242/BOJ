import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String current = st.nextToken();
        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (current.charAt(current.length() - 1) != next.charAt(0)) {
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(1);
    }
}
