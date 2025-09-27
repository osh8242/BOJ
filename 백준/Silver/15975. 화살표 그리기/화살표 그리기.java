import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] points = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            points[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            points[c].add(x);
        }

        long totalDistance = 0;

        for (int c = 1; c <= N; c++) {
            if (points[c].size() > 1) {
                Collections.sort(points[c]);
                for (int i = 0; i < points[c].size(); i++) {
                    if (i == 0) {
                        totalDistance += points[c].get(i + 1) - points[c].get(i);
                    } else if (i == points[c].size() - 1) {
                        totalDistance += points[c].get(i) - points[c].get(i - 1);
                    } else {
                        int distToLeft = points[c].get(i) - points[c].get(i - 1);
                        int distToRight = points[c].get(i + 1) - points[c].get(i);
                        totalDistance += Math.min(distToLeft, distToRight);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(totalDistance);
        System.out.print(sb);
    }
}
