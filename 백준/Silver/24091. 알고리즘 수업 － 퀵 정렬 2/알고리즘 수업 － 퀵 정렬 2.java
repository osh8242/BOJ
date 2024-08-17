import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int swapCount = 0;
    static int N, K;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        quickSort(arr, 0, arr.length - 1);
        bw.write(Integer.toString(-1));
        bw.flush();
    }

    public static void quickSort(int[] arr, int low, int high) throws IOException {
        if (low < high) {
            int pivotIndex = getPivotIndex(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int getPivotIndex(int[] arr, int low, int high) throws IOException {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        if (i + 1 != high) swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) throws IOException {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swapCount++;
        if (swapCount == K) {
            for (int i1 : arr) {
                bw.write(Integer.toString(i1));
                bw.write(" ");
            }
            bw.flush();
            System.exit(0);
        }
    }
}
