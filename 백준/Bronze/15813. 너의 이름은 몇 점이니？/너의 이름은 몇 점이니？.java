import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        char[] chars = br.readLine().toCharArray();
        int score = 0;
        for (char ch : chars) {
            score += ch - 64;
        }
        System.out.println(score);
    }

}
