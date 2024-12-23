import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(N) + " " + (N-2));
    }

    static int fibonacci(int n) {
        if(n == 1 || n == 2) return 1;
        int a = 1;
        int b = 1;
        int c = -1;
        for(int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
