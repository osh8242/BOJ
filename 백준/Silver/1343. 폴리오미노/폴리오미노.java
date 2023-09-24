import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean isX = false;
    static boolean isPossible = true;
    static int index = 0;
    static String boardLine;

    public static void main(String[] args) throws IOException {
        boardLine = br.readLine();
        while (index < boardLine.length()) {
            char ch = boardLine.charAt(index);
            if (ch == 'X' & !isX) {
                int countOfX = 1;
                while (index + countOfX < boardLine.length()) {
                    if (boardLine.charAt(index + countOfX) == 'X') {
                        countOfX++;
                    } else {
                        index += countOfX;
                        isX = false;
                        break;
                    }
                }
                if (index + countOfX == boardLine.length()) index = boardLine.length();
                if (countOfX % 2 == 1) {
                    isPossible = false;
                    break;
                } else {
                    int countA = countOfX / 4;
                    int countB = countOfX % 4 == 0 ? 0 : 1;
                    sb.append("AAAA".repeat(Math.max(0, countA)));
                    sb.append("BB".repeat(Math.max(0, countB)));
                }

            } else {
                sb.append(".");
                index++;
            }
        }
        System.out.println(isPossible ? sb : -1);

    }

}
