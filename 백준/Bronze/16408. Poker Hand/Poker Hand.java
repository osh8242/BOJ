import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] chars = new int[128];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        while (st.hasMoreTokens()) {
            char c = st.nextToken().charAt(0);
            chars[c]++;
            max = Math.max(max, chars[c]);
        }

        System.out.println(max);
    }

}
