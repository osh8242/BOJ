import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        br.close();


        BigInteger[] fib = new BigInteger[N + 3];
        fib[1] = BigInteger.ONE;
        fib[2] = BigInteger.ONE;
        for (int i = 3; i <= N + 2; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }
        BigInteger sum = fib[N + 2].subtract(BigInteger.ONE);

        boolean skipFirst = false;
        if (sum.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) != 0) {
            skipFirst = true;
            sum = sum.subtract(BigInteger.ONE);
        }

        BigInteger half = sum.divide(BigInteger.valueOf(2));

        BigInteger group1Sum = BigInteger.ZERO;
        ArrayList<Integer> group1 = new ArrayList<>();

        int startIdx = skipFirst ? 2 : 1;

        for (int i = N; i >= startIdx; i--) {
            if (group1Sum.add(fib[i]).compareTo(half) <= 0) {
                group1.add(i);
                group1Sum = group1Sum.add(fib[i]);
                if (group1Sum.equals(half)) {
                    break;
                }
            }
        }

        ArrayList<Integer> group2 = new ArrayList<>();
        for (int i = startIdx; i <= N; i++) {
            if (!group1.contains(i)) {
                group2.add(i);
            }
        }

        append(sb, group1);

        append(sb, group2);

        System.out.print(sb);
    }

    private static void append(StringBuilder sb, ArrayList<Integer> group1) {
        sb.append(group1.size()).append("\n");
        for (int i = 0; i < group1.size(); i++) {
            sb.append(group1.get(i));
            if (i < group1.size() - 1) sb.append(" ");
        }
        sb.append("\n");
    }
}
