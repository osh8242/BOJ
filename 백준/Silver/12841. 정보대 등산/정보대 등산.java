import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static long[] crossRoads, leftRoads, rightRoads;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        crossRoads = new long[N + 1];
        leftRoads = new long[N];
        rightRoads = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            crossRoads[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            leftRoads[i] = leftRoads[i - 1] + Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            rightRoads[i] = rightRoads[i - 1] + Integer.parseInt(st.nextToken());
        }
        int index = -1;
        long distance = Long.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            long temp = leftRoads[i - 1] + crossRoads[i] + (rightRoads[N - 1] - rightRoads[i - 1]);
            if (temp < distance) {
                distance = temp;
                index = i;
            }
        }
        System.out.println(index + " " + distance);
    }
}
