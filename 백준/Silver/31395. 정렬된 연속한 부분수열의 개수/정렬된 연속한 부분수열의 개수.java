import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        long count = 0;
        int start = 0;
        for (int end = 0; end < N; end++) {
            if (end == N - 1 || A[end] >= A[end + 1]) {
                long length = end - start + 1;
                count += (length * (length + 1)) / 2;
                start = end + 1;
            }
        }

        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
    }
}
