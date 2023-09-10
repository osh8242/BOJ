import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        final char[] restrict = "CAMBRIDGE".toCharArray();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            boolean isRestricted = false;
            for (char c : restrict) {
                if (ch == c) {
                    isRestricted = true;
                    break;
                }
            }
            if (!isRestricted) sb.append(ch);
        }
        System.out.println(sb);
    }
}
