import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] array, temp;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        temp = new int[N];
        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(br.readLine());
        mergeSort(0, N - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(array[i]).append("\n");
        System.out.println(sb);
    }

    static void mergeSort(int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(start, middle);
            mergeSort(middle + 1, end);

            int left = start;
            int right = middle + 1;
            int index = start;
            while (left <= middle || right <= end) {
                if (right > end || (left <= middle && array[left] < array[right]))
                    temp[index++] = array[left++];
                else temp[index++] = array[right++];
            }
            for (int i = start; i <= end; i++) array[i] = temp[i];
        }
    }

}
