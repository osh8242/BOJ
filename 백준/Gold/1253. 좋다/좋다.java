import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] nums;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            if (isGoodNumber(nums[i], i)) count++;
        }
        System.out.println(count);
    }

    static boolean isGoodNumber(int number, int currentIndex) {
        int startIndex = 0;
        int endIndex = N - 1;
        while (startIndex < endIndex) {
            if (nums[startIndex] + nums[endIndex] == number) {
                if (startIndex != currentIndex && endIndex != currentIndex) return true;
                else if (startIndex == currentIndex) startIndex++;
                else endIndex--;
            } else if (nums[startIndex] + nums[endIndex] < number) startIndex++;
            else endIndex--;
        }
        return false;
    }

}
