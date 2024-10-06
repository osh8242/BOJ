import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] games = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            games[i][0] = Integer.parseInt(st.nextToken());
            games[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] mappings = {
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1}
        };

        int maxWins = 0;

        for (int[] mapping : mappings) {
            maxWins = Math.max(maxWins, winCount(games, mapping, n));
        }

        System.out.println(maxWins);
    }

    static int winCount(int[][] games, int[] mapping, int n) {
        int wins = 0;
        for (int i = 0; i < n; i++) {
            int cow1 = games[i][0];
            int cow2 = games[i][1];

            int mappedCow1 = mapping[cow1 - 1];
            int mappedCow2 = mapping[cow2 - 1];

            if ((mappedCow1 == 1 && mappedCow2 == 3) ||
                    (mappedCow1 == 3 && mappedCow2 == 2) ||
                    (mappedCow1 == 2 && mappedCow2 == 1)) {
                wins++;
            }
        }
        return wins;
    }
}
