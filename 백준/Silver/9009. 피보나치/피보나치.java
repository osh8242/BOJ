import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> fibonacci = new ArrayList<>(100);
    static StringBuilder sb = new StringBuilder();

    static {
        fibonacci.add(0);
        fibonacci.add(1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                sb.append(fibonacci.get(1)).append("\n");
                continue;
            }

            addFibonacci(n);
            appendListOfFibonacci(getListOfFibonacci(n));
        }
        System.out.println(sb);
    }

    static void addFibonacci(int n) {
        while (fibonacci.get(fibonacci.size() - 1) <= n) {
            int size = fibonacci.size();
            fibonacci.add(fibonacci.get(size - 1) + fibonacci.get(size - 2));
        }
    }

    static int findMaxFibonacciValue(int n) {
        int low = 1;
        int high = fibonacci.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (n == fibonacci.get(mid)) {
                return fibonacci.get(mid);
            } else if (n < fibonacci.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return fibonacci.get(high);
    }

    static List<Integer> getListOfFibonacci(int n) {
        List<Integer> list = new ArrayList<>(30);
        while (n > 0) {
            int f = findMaxFibonacciValue(n);
            list.add(f);
            n -= f;
        }
        return list;
    }

    static void appendListOfFibonacci(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        sb.append("\n");
    }

}
