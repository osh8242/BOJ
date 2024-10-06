import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int totalVote = 0;
            int winner = 0;
            int winnerIdx = 0;
            boolean isDuplicate = false;
            for (int i = 1; i <= N; i++) {
                int vote = Integer.parseInt(br.readLine());
                totalVote += vote;
                if (winner < vote) {
                    winnerIdx = i;
                    winner = vote;
                    isDuplicate = false;
                } else if (winner == vote) {
                    isDuplicate = true;
                }
            }
            if (isDuplicate) {
                sb.append("no winner");
            } else {
                sb.append(winner * 2 > totalVote ? "majority " : "minority ").append("winner ").append(winnerIdx);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}
