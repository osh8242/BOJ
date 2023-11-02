import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] nums, temp;
    static int[] testNums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        temp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        testNums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) testNums[i] = Integer.parseInt(st.nextToken());
        mergeSort(0, N - 1);
        for (int i = 0; i < M; i++) {
            if (binarySearch(testNums[i]) != -1) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void mergeSort(int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            mergeSort(start, middle);
            mergeSort(middle + 1, end);

            int left = start;
            int right = middle + 1;
            int index = start;
            while (left <= middle || right <= end) {
                if (left > middle || (right <= end && nums[left] > nums[right]))
                    temp[index++] = nums[right++];
                else temp[index++] = nums[left++];
            }
            System.arraycopy(temp, start, nums, start, end + 1 - start);
        }
    }

    static int binarySearch(int num) {
        int left = 0;
        int right = N - 1;
        int middle = left + (right - left) / 2;
        while (left < right) {
            if (nums[middle] > num) {
                right = middle;
                middle = left + (right - left) / 2;
            } else if (nums[middle] < num) {
                left = middle + 1;
                middle = left + (right - left) / 2;
            } else return middle;
        }
        return nums[middle] == num ? middle : -1;
    }

}