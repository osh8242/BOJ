import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<Integer> dp;
    static int[] inputs, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];
        answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        dp = new ArrayList<>();
        dp.add(inputs[0]);
        for (int i = 0; i < N; i++) {
            int value = inputs[i];
            if (value > dp.get(dp.size() - 1)) dp.add(value);
            else binarySearch(value, dp);
            answer[i] += dp.size();
        }

        dp.clear();
        dp.add(inputs[N - 1]);
        int max = 0;
        for (int i = N - 1; i >= 0; i--) {
            int value = inputs[i];
            if (value > dp.get(dp.size() - 1)) dp.add(value);
            else binarySearch(value, dp);
            answer[i] += dp.size();
            max = Math.max(max, answer[i]);
        }

        System.out.println(max - 1);
    }

    static void binarySearch(int value, List<Integer> dp) {
        int left = 0;
        int right = dp.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int midValue = dp.get((left + right) / 2);
            if (value > midValue) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        dp.set(left, value);
    }

}