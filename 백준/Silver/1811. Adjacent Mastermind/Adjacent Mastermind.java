import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder output = new StringBuilder();
        while ((line = br.readLine()) != null) {
            if (line.equals("#")) break;
            String[] parts = line.split(" ");
            String target = parts[0];
            String guess = parts[1];
            int n = target.length();
            boolean[] matchedT = new boolean[n];
            boolean[] matchedG = new boolean[n];
            int black = 0, grey = 0, white = 0;
            for (int i = 0; i < n; i++) {
                if (guess.charAt(i) == target.charAt(i)) {
                    matchedT[i] = true;
                    matchedG[i] = true;
                    black++;
                }
            }
            for (int i = 0; i < n; i++) {
                if (matchedG[i]) continue;
                char g = guess.charAt(i);
                int[] adj = {i - 1, i + 1};
                for (int j : adj) {
                    if (j >= 0 && j < n && !matchedT[j] && target.charAt(j) == g) {
                        matchedT[j] = true;
                        matchedG[i] = true;
                        grey++;
                        break;
                    }
                }
            }
            int[] freqT = new int[26];
            for (int i = 0; i < n; i++) {
                if (!matchedT[i]) {
                    freqT[target.charAt(i) - 'A']++;
                }
            }
            for (int i = 0; i < n; i++) {
                if (!matchedG[i]) {
                    int idx = guess.charAt(i) - 'A';
                    if (freqT[idx] > 0) {
                        freqT[idx]--;
                        white++;
                    }
                }
            }
            output.append(guess)
                  .append(": ")
                  .append(black).append(" black, ")
                  .append(grey).append(" grey, ")
                  .append(white).append(" white")
                  .append('\n');
        }
        System.out.print(output.toString());
    }
}