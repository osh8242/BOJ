import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x0 = Integer.parseInt(st.nextToken());
        int y0 = Integer.parseInt(st.nextToken());
        int[][] persons = new int[3][2];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            persons[i][0] = Integer.parseInt(st.nextToken());
            persons[i][1] = Integer.parseInt(st.nextToken());
        }
        double minDist = Double.MAX_VALUE;
        int[] perm = {0, 1, 2};
        do {
            double dist = 0;
            int prevX = x0, prevY = y0;
            for (int i = 0; i < 3; i++) {
                int idx = perm[i];
                dist += distance(prevX, prevY, persons[idx][0], persons[idx][1]);
                prevX = persons[idx][0];
                prevY = persons[idx][1];
            }
            if (dist < minDist) {
                minDist = dist;
            }
        } while (nextPermutation(perm));
        System.out.println((int) minDist);
    }

    public static double distance(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i <= 0) return false;
        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }
        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;
        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
