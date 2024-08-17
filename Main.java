import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] zeros;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        zeros = new int[N][M+1];
        for (int i = 0; i < N; i++) {
            readRowZeroCount(br.readLine(), i);
        }
        int answer = 0;
        for (int[] rowZeros : zeros) {
            for(int j = K ; j <= M ; j++) {
                answer += rowZeros[j] * (j - K + 1);
            }
        }
        bw.write(Integer.toString(answer));
        bw.flush();
    }

    static void readRowZeroCount(String line, int rowIndex) throws IOException {
        boolean isZero = false;
        int zeroCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '0') {
                if (!isZero) isZero = true;
                zeroCount++;
            } else if (isZero) {
                isZero = false;
                zeros[rowIndex][zeroCount]++;
                zeroCount = 0;
            }
        }
        if(isZero) zeros[rowIndex][zeroCount]++;
    }

}
