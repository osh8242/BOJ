import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    boolean isPalindrome(int number) {
        int originNumber = number;
        int reversedNumber = 0;
        while (originNumber > 0) {
            int digit = originNumber % 10;
            reversedNumber = 10 * reversedNumber + digit;
            originNumber /= 10;
        }
        return number == reversedNumber;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int LIMIT = 10000000;
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[LIMIT + 1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i <= LIMIT; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * 2; j <= LIMIT; j += i) {
                if (j % i == 0) isPrime[j] = false;
            }
        }
        int answer = 0;
        for (int i = N; i <= LIMIT; i++) {
            if (isPrime[i] && isPalindrome(i)) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
