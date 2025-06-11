import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        System.out.println(sb);
    }
}
