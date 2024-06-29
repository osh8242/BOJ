import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] median = new int[N];
        for (int i = 0; i < N; i++) {
            int[] row = new int[N];
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                row[j] = Integer.parseInt(line[j]);
            }
            Arrays.sort(row);
            median[i] = row[row.length / 2];
        }
        Arrays.sort(median);
        System.out.println(median[median.length / 2]);
    }
}
