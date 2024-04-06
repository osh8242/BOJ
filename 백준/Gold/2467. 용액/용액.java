import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] properties = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            properties[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int resultLeft = left, resultRight = right;

        while (left < right) {
            int sum = properties[left] + properties[right];

            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                resultLeft = properties[left];
                resultRight = properties[right];
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break;
            }
        }
        System.out.println(resultLeft + " " + resultRight);
    }
}
