import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        double val = Math.sqrt(1.0 + 8.0 * n);
        long h = (long) Math.floor((-1 + val) / 2.0);
        System.out.println(h);
    }
}
