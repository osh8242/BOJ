import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int code = (int) c;
            int sum = 0;
            while (code > 0) {
                sum += code % 10;
                code /= 10;
            }
            for (int i = 0; i < sum; i++) {
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}