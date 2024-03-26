import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int count = 0;
    static int answer = -1;
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        int answer = -1;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primeProcess(i);
                for (int j = i * i; j < isPrime.length; j += i) {
                    primeProcess(j);
                }
            }
        }
        System.out.println(answer);
    }

    static void primeProcess(int num){
        if(isPrime[num]){
            isPrime[num] = false;
            count++;
            if(count == K){
                System.out.println(num);
                System.exit(0);
            }
        }
    }

}

