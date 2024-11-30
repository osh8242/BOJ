import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(positions);

        long distance = 0;
        for (int i = positions.length - 1; i >= 0; i -= K) {
            distance += 2L * Math.abs(positions[i]);
        }

        System.out.println(distance);
    }

    static void mergeSort(int[] array) {
        if (array.length == 1) return;

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    static void merge(int[] array, int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, mainIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                array[mainIndex++] = left[leftIndex++];
            } else {
                array[mainIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            array[mainIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            array[mainIndex++] = right[rightIndex++];
        }
    }

}
