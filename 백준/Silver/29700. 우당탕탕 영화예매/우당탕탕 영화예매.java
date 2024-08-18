import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int[] rowZeros = readRowZeroCount(br.readLine());
            for (int j = K; j <= M; j++) {
                answer += rowZeros[j] * (j - K + 1);
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    static int[] readRowZeroCount(String line) throws IOException {
        int[] rowZeros = new int[M + 1];
        boolean isZero = false;
        int zeroCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '0') {
                if (!isZero) isZero = true;
                zeroCount++;
            } else if (isZero) {
                isZero = false;
                rowZeros[zeroCount]++;
                zeroCount = 0;
            }
        }
        if (isZero) rowZeros[zeroCount]++;
        return rowZeros;
    }

}
