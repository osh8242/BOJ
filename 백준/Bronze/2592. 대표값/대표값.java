import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[101];
        int maxCount = 0;
        int maxCountValue = -1;
        int average = 0;
        for (int i = 1; i <= 10; i++) {
            int value = Integer.parseInt(br.readLine()) / 10;
            average += value;
            if (++count[value] > maxCount) {
                maxCount = count[value];
                maxCountValue = value * 10;
            }
        }
        System.out.println(average + "\n" + maxCountValue);
    }

}
