import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(nk.nextToken());
        long K = Long.parseLong(nk.nextToken());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long count = 0;
        for (int i = 1; i < N; i++) {
            int newItem = A[i];
            int loc = i - 1;
            while (loc >= 0 && newItem < A[loc]) {
                A[loc + 1] = A[loc];
                count++;
                if (count == K) {
                    printArray(A);
                    return;
                }
                loc--;
            }
            if (loc + 1 != i) {
                A[loc + 1] = newItem;
                count++;
                if (count == K) {
                    printArray(A);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    static void printArray(int[] A) {
        StringBuilder sb = new StringBuilder();
        for (int v : A) {
            sb.append(v).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
