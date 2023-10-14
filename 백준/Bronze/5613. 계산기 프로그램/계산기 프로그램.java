import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int answer = Integer.parseInt(br.readLine());
        String line = "";
        while (true) {
            line = br.readLine();
            switch (line.charAt(0)) {
                case '=': {
                    System.out.println(answer);
                    return;
                }
                case '+': {
                    answer += Integer.parseInt(br.readLine());
                    break;
                }
                case '-': {
                    answer -= Integer.parseInt(br.readLine());
                    break;
                }
                case '*': {
                    answer *= Integer.parseInt(br.readLine());
                    break;
                }
                case '/': {
                    answer /= Integer.parseInt(br.readLine());
                    break;
                }
            }
        }
    }
}
