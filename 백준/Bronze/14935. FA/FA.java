import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int F(String s) {
        int first = s.charAt(0) - '0';
        int len = s.length();
        return first * len;
    }
    static int F(int x) {
        String s = Integer.toString(x);
        int first = s.charAt(0) - '0';
        int len = s.length();
        return first * len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine().trim();
        int y = F(x);
        if (y == F(y)) {
            System.out.println("FA");
            return;
        }
        Set<Integer> seen = new HashSet<>();
        while (true) {
            if (seen.contains(y)) {
                System.out.println("NFA");
                return;
            }
            seen.add(y);
            int ny = F(y);
            if (ny == y) {
                System.out.println("FA");
                return;
            }
            y = ny;
        }
    }
}
