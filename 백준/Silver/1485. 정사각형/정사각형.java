import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int[][] points = new int[4][2];  // 4개의 점 (x, y)

            // 4개의 점 좌표 입력받기
            for (int i = 0; i < 4; i++) {
                String[] input = br.readLine().split(" ");
                points[i][0] = Integer.parseInt(input[0]);
                points[i][1] = Integer.parseInt(input[1]);
            }

            // 6개의 거리 계산 (4개의 점이므로 6개의 쌍이 존재)
            long[] distances = new long[6];  // 거리를 long 타입으로 변경
            int index = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    distances[index++] = calculateDistance(points[i], points[j]);
                }
            }

            // 거리 정렬
            Arrays.sort(distances);

            // 정사각형이 되려면: 4개의 변이 같고, 2개의 대각선이 같아야 함
            sb.append((distances[0] == distances[1] && distances[1] == distances[2] && distances[2] == distances[3]
                    && distances[4] == distances[5]) ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // 두 점 사이의 거리 계산 (long 타입으로 변경)
    private static long calculateDistance(int[] p1, int[] p2) {
        long dx = p2[0] - p1[0];  // dx를 long 타입으로 변경
        long dy = p2[1] - p1[1];  // dy를 long 타입으로 변경
        return dx * dx + dy * dy; // 거리를 long 타입으로 계산
    }
}
