import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] lectures;
    static int totalTime = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lectures = new int[N];
        st = new StringTokenizer(br.readLine());
        lectures[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            totalTime += lectures[i];
        }
        int minSize = getMinSize(M, totalTime);
        System.out.println(minSize);


    }

    static int getMinSize(int blurayNum, int totalTime) {
        int testSize = totalTime / M;
        if (!canRecord(blurayNum, testSize)) {
            testSize++;
            while (true) {
                if (!canRecord(blurayNum, testSize)) testSize++;
                else break;
            }
        } else {
            testSize--;
            while (true) {
                if (canRecord(blurayNum, testSize)) testSize--;
                else break;
            }
        }
        return testSize;
    }

    static boolean canRecord(int blurayNum, int size) {
        int blurayCount = 1;
        int tempSum = 0;
        for (int i = 0; i < N; i++) {
            if (tempSum + lectures[i] <= size) tempSum += lectures[i];
            else {
                if (size < lectures[i]) return false;
                blurayCount++;
                tempSum = 0;
                i--;
            }
        }
        return blurayCount <= blurayNum;
    }

}