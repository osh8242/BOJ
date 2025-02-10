import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] fibonacci = {
            0, 1, 1, 2, 3,
            5, 8, 13, 21, 34,
            55, 89, 144, 233, 377,
            610, 987, 1597, 2584, 4181,
            6765, 10946, 17711, 28657, 46368,
            75025, 121393, 196418, 317811, 514229,
            832040, 1346269, 2178309, 3524578, 5702887,
            9227465, 14930352, 24157817, 39088169, 63245986,
            102334155, 165580141, 267914296, 433494437, 701408733
    };

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                sb.append(fibonacci[1]).append("\n");
                continue;
            }

            appendListOfFibonacci(getListOfFibonacci(n));
        }
        System.out.println(sb);
    }

    static int findMaxFibonacciValue(int n) {
        int low = 1;
        int high = fibonacci.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (n == fibonacci[mid]) {
                return fibonacci[mid];
            } else if (n < fibonacci[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return fibonacci[high];
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
