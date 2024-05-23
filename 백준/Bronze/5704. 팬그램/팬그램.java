import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = br.readLine()).equals("*")) {
            boolean[] counts = new boolean[26];
            int count = 0;
            for (char c : line.toCharArray()) {
                if (c == ' ') continue;
                if (!counts[c - 'a']) {
                    counts[c - 'a'] = true;
                    count++;
                }
            }
            sb.append(count == 26 ? "Y" : "N").append("\n");
        }
        System.out.println(sb);
    }

}
