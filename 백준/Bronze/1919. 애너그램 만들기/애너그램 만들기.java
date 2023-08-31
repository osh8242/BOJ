import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] counts = new int[26];
        String firstWord = br.readLine();
        for (char c : firstWord.toCharArray()) {
            counts[c - 97]++;
        }
        String secondWord = br.readLine();
        for (char c : secondWord.toCharArray()) {
            counts[c - 97]--;
        }
        int sum = 0;
        for (int count : counts) {
            sum += count >= 0 ? count : -count;
        }
        System.out.println(sum);
    }
}
