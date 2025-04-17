import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        while (true) {
            int bet = Integer.parseInt(br.readLine().trim());
            if (bet == -1) break;
            sum += bet;
        }

        System.out.println(sum);
    }
}
