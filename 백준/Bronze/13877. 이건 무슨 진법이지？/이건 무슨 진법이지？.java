import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            sb.append(test_case).append(" ");
            String decimalNumber = st.nextToken();
            sb.append(getValueFromDecimal(decimalNumber, 8)).append(" ");
            sb.append(getValueFromDecimal(decimalNumber, 10)).append(" ");
            sb.append(getValueFromDecimal(decimalNumber, 16)).append("\n");
        }
        System.out.println(sb);

    }

    static int getValueFromDecimal(String decimalNumber, int ref) {
        int answer = 0;
        int factor = 1;
        for (int i = decimalNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(decimalNumber.charAt(i));
            if (digit >= ref) return 0;
            answer += digit * factor;
            factor *= ref;
        }
        return answer;
    }
}
