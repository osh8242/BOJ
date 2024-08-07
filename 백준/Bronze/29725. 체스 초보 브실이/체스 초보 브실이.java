import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int whiteScore = 0;
        int blackScore = 0;

        Map<Character, Integer> scores = new HashMap<>();
        scores.put('P', 1);
        scores.put('N', 3);
        scores.put('B', 3);
        scores.put('R', 5);
        scores.put('Q', 9);
        scores.put('K', 0);
        scores.put('p', 1);
        scores.put('n', 3);
        scores.put('b', 3);
        scores.put('r', 5);
        scores.put('q', 9);
        scores.put('k', 0);

        for (int i = 0; i < 8; i++) {
            String line = br.readLine();
            for (char piece : line.toCharArray()) {
                if (isValidPiece(piece, scores)) {
                    if (Character.isUpperCase(piece)) {
                        whiteScore += scores.get(piece);
                    } else {
                        blackScore += scores.get(piece);
                    }
                }
            }
        }

        int scoreDifference = whiteScore - blackScore;
        System.out.println(scoreDifference);
    }

    private static boolean isValidPiece(char piece, Map<Character, Integer> scores) {
        return scores.containsKey(piece);
    }
}
