import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) isPrime[j] = false;
            }
        }
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) primes.add(i);
        }
        int count, sum, s, e;
        count = sum = s = e = 0;
        while (true) {
            if (sum >= N) sum -= primes.get(s++);
            else if (e == primes.size()) break;
            else sum += primes.get(e++);
            if (sum == N) count++;
        }
        System.out.println(count);
    }

}

