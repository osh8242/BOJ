import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[3];
        for (int i = 0; i < 3; i++) {
            s[i] = br.readLine();
        }
        int start = 0;
        for (int i = 0; i < 3; i++) {
            String t = s[i];
            if (!t.equals("Fizz") && !t.equals("Buzz") && !t.equals("FizzBuzz")) {
                int x = Integer.parseInt(t);
                start = x - i;
                break;
            }
        }
        int next = start + 3;
        StringBuilder sb = new StringBuilder();
        if (next % 15 == 0) sb.append("FizzBuzz");
        else if (next % 3 == 0) sb.append("Fizz");
        else if (next % 5 == 0) sb.append("Buzz");
        else sb.append(next);
        System.out.println(sb.toString());
    }
}