import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long count;
    static int K;
    static int answer = -1;
    static int[] A;
    static int[] tmp;

    public static void merge_sort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(p, q);
            merge_sort(q + 1, r);
            merge(p, q, r);
        }
    }

    public static void merge(int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }
        while (i <= q) {
            tmp[t++] = A[i++];
        }
        while (j <= r) {
            tmp[t++] = A[j++];
        }
        i = p;
        t = 0;
        while (i <= r) {
            A[i++] = tmp[t++];
            count++;
            if (count == K) {
                answer = A[i - 1];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);
        A = new int[N];
        tmp = new int[N];
        String[] parts = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(parts[i]);
        }
        merge_sort(0, N - 1);
        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.print(sb.toString());
    }
}
