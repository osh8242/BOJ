import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String quiz = "";
        int difficulty = Integer.MAX_VALUE;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String tempQuiz = st.nextToken();
            int tempDifficulty = Integer.parseInt(st.nextToken());
            if(difficulty > tempDifficulty) {
                difficulty = tempDifficulty;
                quiz = tempQuiz;
            }
        }
        bw.write(quiz);
        bw.flush();
    }

}
