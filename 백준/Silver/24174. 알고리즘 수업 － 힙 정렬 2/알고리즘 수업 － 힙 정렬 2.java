import java.io.*;
import java.util.*;

public class Main {
    static int[] A;
    static int swapCount = 0;
    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N + 1]; // 1-based indexing
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        buildMinHeap(N);
        if (swapCount >= K) {
            printResult();
            return;
        }

        for (int i = N; i >= 2; i--) {
            swap(1, i);
            if (check()) return;

            heapify(1, i - 1);
            if (swapCount >= K) break;
        }

        System.out.println(swapCount >= K ? getResultString() : -1);
    }

    static void buildMinHeap(int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(i, n);
            if (swapCount >= K) return;
        }
    }

    static void heapify(int k, int n) {
        while (true) {
            int left = 2 * k;
            int right = 2 * k + 1;
            int smaller = -1;

            if (right <= n) {
                smaller = A[left] < A[right] ? left : right;
            } else if (left <= n) {
                smaller = left;
            } else {
                return;
            }

            if (A[smaller] < A[k]) {
                swap(k, smaller);
                if (check()) return;
                k = smaller;
            } else {
                return;
            }
        }
    }

    static void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        swapCount++;
    }

    static boolean check() {
        if (swapCount == K) {
            System.out.println(getResultString());
            System.exit(0);
        }
        return swapCount >= K;
    }

    static String getResultString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(A[i]).append(' ');
        }
        return sb.toString().trim();
    }

    static void printResult() {
        System.out.println(getResultString());
    }
}
