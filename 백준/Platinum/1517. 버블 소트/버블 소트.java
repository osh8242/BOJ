import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] array, temp;
    static long swapCount = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        temp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(st.nextToken());
        mergeSort(0, N - 1);
        System.out.println(swapCount);
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
                if (right > end || (left <= middle && array[left] < array[right])) {
                    temp[index++] = array[left++];
                } else {
                    if(array[right] != array[index]) swapCount += right - index;
                    temp[index++] = array[right++];
                }
            }
            for (int i = start; i <= end; i++) array[i] = temp[i];
        }
    }

}
