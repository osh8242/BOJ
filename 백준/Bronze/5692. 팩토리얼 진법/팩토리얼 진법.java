import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] factorial = new int[6];

    static {
        factorial[1] = 1;
        for (int i = 2; i <= 5; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    public static void main(String[] args) throws Exception {
        String input;
        while (!(input = br.readLine()).equals("0")) {
            int answer = 0;
            for (int i = 1; i <= input.length(); i++) {
                int digit = input.charAt(input.length() - i) - '0';
                answer += digit * factorial[i];
            }
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
