import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 줄 입력: 도시 수(N)와 버스 수(M)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityCount = Integer.parseInt(st.nextToken());
        int busCount = Integer.parseInt(st.nextToken());

        // 버스 경로 입력
        int[] busRoutes = new int[busCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < busCount; i++) {
            busRoutes[i] = Integer.parseInt(st.nextToken()) - 1; // 0-based index
        }

        // 도시 간 거리 맵 입력
        int[][] distanceMap = new int[cityCount][cityCount];
        for (int i = 0; i < cityCount; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cityCount; j++) {
                distanceMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 이동 거리 계산
        int totalDistance = 0;
        for (int i = 0; i < busRoutes.length - 1; i++) {
            int startCity = busRoutes[i];
            int endCity = busRoutes[i + 1];
            totalDistance += distanceMap[startCity][endCity];
        }

        // 결과 출력
        System.out.println(totalDistance);
    }
}
