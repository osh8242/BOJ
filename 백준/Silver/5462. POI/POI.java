import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] np = br.readLine().split(" ");
        int N = Integer.parseInt(np[0]);
        int T = Integer.parseInt(np[1]);
        int P = Integer.parseInt(np[2]) - 1;
        int[][] solve = new int[N][T];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < T; j++) {
                solve[i][j] = Integer.parseInt(line[j]);
            }
        }
        int[] cntZero = new int[T];
        for (int j = 0; j < T; j++) {
            int c = 0;
            for (int i = 0; i < N; i++) {
                if (solve[i][j] == 0) c++;
            }
            cntZero[j] = c;
        }
        int[] score = new int[N];
        int[] solvedCnt = new int[N];
        for (int i = 0; i < N; i++) {
            int sc = 0;
            int cnt = 0;
            for (int j = 0; j < T; j++) {
                if (solve[i][j] == 1) {
                    sc += cntZero[j];
                    cnt++;
                }
            }
            score[i] = sc;
            solvedCnt[i] = cnt;
        }
        int philScore = score[P];
        int philSolved = solvedCnt[P];
        int ahead = 0;
        for (int i = 0; i < N; i++) {
            if (i == P) continue;
            if (score[i] > philScore
                || (score[i] == philScore && solvedCnt[i] > philSolved)
                || (score[i] == philScore && solvedCnt[i] == philSolved && i < P)) {
                ahead++;
            }
        }
        int rank = ahead + 1;
        System.out.print(philScore + " " + rank);
    }
}
