import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int n = S.length();
        for (int A = 1; A <= 999; A++) {
            StringBuilder sb = new StringBuilder();
            int i = A;
            while (sb.length() < n && i <= 999) {
                sb.append(i);
                i++;
            }
            if (sb.length() == n && sb.toString().equals(S)) {
                StringBuilder output = new StringBuilder();
                output.append(A).append(' ').append(i - 1);
                System.out.println(output.toString());
                return;
            }
        }
    }
}
