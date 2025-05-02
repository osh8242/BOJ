import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        String vowels = "AEIOUaeiou";

        for (int i = 0; i < S; i++) {
            String line = br.readLine();
            int vCount = 0, cCount = 0;
            for (char ch : line.toCharArray()) {
                if (Character.isLetter(ch)) {
                    if (vowels.indexOf(ch) >= 0) vCount++;
                    else cCount++;
                }
            }
            sb.append(cCount).append(' ').append(vCount).append('\n');
        }

        System.out.print(sb);
    }
}
