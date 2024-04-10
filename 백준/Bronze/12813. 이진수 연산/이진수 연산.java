import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        StringBuilder andResult = new StringBuilder();
        StringBuilder orResult = new StringBuilder();
        StringBuilder xorResult = new StringBuilder();
        StringBuilder notAResult = new StringBuilder();
        StringBuilder notBResult = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);

            // AND 연산
            andResult.append((a == '1' && b == '1') ? '1' : '0');
            // OR 연산
            orResult.append((a == '1' || b == '1') ? '1' : '0');
            // XOR 연산
            xorResult.append((a != b) ? '1' : '0');
            // NOT 연산
            notAResult.append((a == '1') ? '0' : '1');
            notBResult.append((b == '1') ? '0' : '1');
        }

        System.out.println(andResult);
        System.out.println(orResult);
        System.out.println(xorResult);
        System.out.println(notAResult);
        System.out.println(notBResult);
    }
}
