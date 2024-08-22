import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] matrix;
    static int N;
    static int sum;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        sum = N * (N * N + 1) / 2;
        matrix = new int[N][N];
        HashSet<Integer> set = new HashSet<>();
        
        // 행렬 입력 및 중복 체크
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                matrix[i][j] = value;
                if (value < 1 || value > N * N || !set.add(value)) {
                    bw.write("FALSE");
                    bw.flush();
                    return;
                }
            }
        }

        // 행, 열, 대각선 체크
        if (checkRow() && checkCol() && checkDiagonal1() && checkDiagonal2()) {
            bw.write("TRUE");
        } else {
            bw.write("FALSE");
        }
        bw.flush();
        bw.close();
    }

    static boolean checkRow() {
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < N; j++) {
                temp += matrix[i][j];
            }
            if (temp != sum) return false;
        }
        return true;
    }

    static boolean checkCol() {
        for (int j = 0; j < N; j++) {
            int temp = 0;
            for (int i = 0; i < N; i++) {
                temp += matrix[i][j];
            }
            if (temp != sum) return false;
        }
        return true;
    }

    static boolean checkDiagonal1() {
        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp += matrix[i][i];
        }
        return temp == sum;
    }

    static boolean checkDiagonal2() {
        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp += matrix[i][N - i - 1];
        }
        return temp == sum;
    }
}
