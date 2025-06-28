import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String invertCase(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c))      sb.append(Character.toUpperCase(c));
            else if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else                               sb.append(c);
        }
        return sb.toString();
    }

    static String removeDigits(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder out = new StringBuilder();
        for (int tc = 1; tc <= n; tc++) {
            String[] parts = br.readLine().split(" ");
            String orig = parts[0], in = parts[1];

            // 기본 변환 결과 미리 계산
            String inv    = invertCase(orig);
            String rem    = removeDigits(orig);
            String invRem = removeDigits(inv);

            // 원본에 숫자/문자가 있는지 검사
            boolean hasDigit  = orig.chars().anyMatch(Character::isDigit);
            boolean hasLetter = orig.chars().anyMatch(Character::isLetter);

            boolean ok      = in.equals(orig);
            boolean caps    = in.equals(inv);
            boolean num     = in.equals(rem);
            // both: caps+num 실제 적용 가능한 경우(원본에 숫자도 문자도 있어야 함)
            boolean both    = hasDigit && hasLetter && in.equals(invRem);

            out.append("Case ").append(tc).append(": ");
            if (ok) {
                out.append("Login successful.");
            } else if (both) {
                out.append("Wrong password. Please, check your caps lock and num lock keys.");
            } else if (caps) {
                out.append("Wrong password. Please, check your caps lock key.");
            } else if (num) {
                out.append("Wrong password. Please, check your num lock key.");
            } else {
                out.append("Wrong password.");
            }
            out.append('\n');
        }
        System.out.print(out);
    }
}
