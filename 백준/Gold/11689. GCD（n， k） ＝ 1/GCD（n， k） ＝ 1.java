import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long n = Long.parseLong(br.readLine());
        long answer = n;
        for (long divisor = 2; divisor <= Math.sqrt(n); divisor++) {
            if (n % divisor == 0) {
                answer -= answer / divisor;
            }
            while (n % divisor == 0) {
                n /= divisor;
            }
        }
        if (n > 1) answer -= answer / n;
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}
