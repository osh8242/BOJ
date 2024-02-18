import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] map;
    static boolean[] isVisit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisit = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        makeTeam(0, 0);
        System.out.println(min);
    }

    static void makeTeam(int index, int count) {
        if (count == N / 2) {
            min = Math.min(min, getPoint());
            return;
        }
        for (int i = index; i < N; i++) {
            isVisit[i] = true;
            makeTeam(i + 1, count + 1);
            isVisit[i] = false;
        }
    }

    static int getPoint() {
        int trueSum = 0;
        int falseSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isVisit[i] && isVisit[j]) trueSum += map[i][j] + map[j][i];
                else if (!isVisit[i] && !isVisit[j]) falseSum += map[i][j] + map[j][i];
            }
        }
        return Math.abs(trueSum - falseSum);
    }
}
