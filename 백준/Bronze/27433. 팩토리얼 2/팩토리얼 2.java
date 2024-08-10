import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(getFactorial(N));
    }

    static long getFactorial(int n) {
        if(n == 0 || n == 1) return 1;
        return n * getFactorial(n - 1);
    }

}
