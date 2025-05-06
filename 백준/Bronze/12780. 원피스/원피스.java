import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String H = br.readLine();
        String N = br.readLine();
        int hLen = H.length(), nLen = N.length();
        int count = 0;
        for (int i = 0; i + nLen <= hLen; i++) {
            if (H.regionMatches(i, N, 0, nLen)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
