import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        while (N-- > 0) {
            int current = Integer.parseInt(br.readLine());
            if (current >= 0) positives.add(current);
            else negatives.add(-current);
        }

        mergeSort(positives);
        mergeSort(negatives);

        long distance = 0;
        for (int i = positives.size() - 1; i >= 0; i -= K) {
            distance += 2L * positives.get(i);
        }
        for (int i = negatives.size() - 1; i >= 0; i -= K) {
            distance += 2L * negatives.get(i);
        }

        System.out.println(distance);
    }

    static void mergeSort(List<Integer> array) {
        if (array.size() <= 1) return;

        int mid = array.size() / 2;
        List<Integer> left = new ArrayList<>(array.subList(0, mid));
        List<Integer> right = new ArrayList<>(array.subList(mid, array.size()));

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    static void merge(List<Integer> array, List<Integer> left, List<Integer> right) {
        int leftIndex = 0, rightIndex = 0, mainIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                array.set(mainIndex++, left.get(leftIndex++));
            } else {
                array.set(mainIndex++, right.get(rightIndex++));
            }
        }
        while (leftIndex < left.size()) {
            array.set(mainIndex++, left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            array.set(mainIndex++, right.get(rightIndex++));
        }
    }
}