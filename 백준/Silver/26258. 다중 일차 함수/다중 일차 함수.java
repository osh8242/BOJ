
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        points = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            double k = Double.parseDouble(br.readLine());
            int i = binarySearch(k);
            sb.append(Integer.compare(points[i+1][1], points[i][1])).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static int binarySearch(double k) {
        int left = 0;
        int right = points.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (points[mid][0] <= k && k < points[mid + 1][0]) {
                return mid;
            } else if (points[mid][0] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
