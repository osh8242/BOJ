import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine().trim();
        String[][] digits = new String[10][5];
        digits[0] = new String[]{"0000", "0  0", "0  0", "0  0", "0000"};
        digits[1] = new String[]{"   1", "   1", "   1", "   1", "   1"};
        digits[2] = new String[]{"2222", "   2", "2222", "2", "2222"};
        digits[3] = new String[]{"3333", "   3", "3333", "   3", "3333"};
        digits[4] = new String[]{"4  4", "4  4", "4444", "   4", "   4"};
        digits[5] = new String[]{"5555", "5", "5555", "   5", "5555"};
        digits[6] = new String[]{"6666", "6", "6666", "6  6", "6666"};
        digits[7] = new String[]{"7777", "   7", "   7", "   7", "   7"};
        digits[8] = new String[]{"8888", "8  8", "8888", "8  8", "8888"};
        digits[9] = new String[]{"9999", "9  9", "9999", "   9", "   9"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            int d = num.charAt(i) - '0';
            for (int j = 0; j < 5; j++) {
                sb.append(digits[d][j]).append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
