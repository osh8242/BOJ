import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        int caseNumber = 1;
        while (!(input = br.readLine()).equals("0")) {
            int N = Integer.parseInt(input);
            int countFive = 0;
            for (int i = 5; i <= N; i *= 5) {
                countFive += N / i;
            }
            sb.append("Case #").append(caseNumber++).append(": ").append(countFive).append("\n");
        }

        System.out.println(sb);
    }
}
