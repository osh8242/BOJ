import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] rot13 = new char[128]; // ASCII 문자 범위: 0~127

    static {
        for (int i = 0; i < 128; i++) {
            if (i >= 'A' && i <= 'Z') {
                rot13[i] = (char) ((i - 'A' + 13) % 26 + 'A');
            } else if (i >= 'a' && i <= 'z') {
                rot13[i] = (char) ((i - 'a' + 13) % 26 + 'a');
            } else {
                rot13[i] = (char) i;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        for (char c : input.toCharArray()) {
            sb.append(rot13[c]);
        }
        System.out.println(sb);
    }
}
