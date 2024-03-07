import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] alphabets = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String line = br.readLine();
            int factor = 1;
            for (int i = line.length() - 1; i >= 0; i--) {
                int index = line.charAt(i) - 'A';
                alphabets[index] += factor;
                factor *= 10;
            }
        }
        Arrays.sort(alphabets);
        int answer = 0;
        int factor = 9;
        for (int i = 25; i > 15; i--) {
            answer += alphabets[i] * factor--;
        }
        System.out.println(answer);
    }
}