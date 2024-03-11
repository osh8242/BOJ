import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] locations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        locations = new int[N];
        for (int i = 0; i < N; i++) {
            locations[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(locations);
        int answer = binarySearch();
        System.out.println(answer);
    }

    static int binarySearch() {
        int low = 1;
        int high = locations[N - 1] - locations[0] + 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if(countByDistance(mid) < C) high = mid;
            else low = mid +1;
        }
        return low - 1;
    }

    static int countByDistance(int distance){
        int answer = 1;
        int prev = locations[0];
        for(int i = 1;  i < N; i++){
            int current = locations[i];
            if(current - prev >= distance){
                answer++;
                prev = current;
            }
        }
        return answer;
    }

}