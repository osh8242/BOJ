import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0 && d == 0) break;
            int count = getCount(a, b, c, d);
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static int getCount(int a, int b, int c, int d) {
        int count = 0;
        int[] values = {a, b, c, d};

        while (!isUniform(values)) {
            count++;
            values = computeDifferences(values);
        }
        return count;
    }

    static boolean isUniform(int[] arr) {
        return (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]);
    }

    static int[] computeDifferences(int[] arr) {
        int[] result = new int[4];
        result[0] = Math.abs(arr[0] - arr[1]);
        result[1] = Math.abs(arr[1] - arr[2]);
        result[2] = Math.abs(arr[2] - arr[3]);
        result[3] = Math.abs(arr[3] - arr[0]);
        return result;
    }
}
