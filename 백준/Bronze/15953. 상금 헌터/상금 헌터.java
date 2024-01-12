import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] prizeTable1 = {0, 500, 300, 200, 50, 30, 10};
    static int[] ratingTable1 = {0, 1, 3, 6, 10, 15, 21};
    static int[] prizeTable2 = {0, 512, 256, 128, 64, 32};
    static int[] ratingTable2 = {0, 1, 3, 7, 15, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rating1 = Integer.parseInt(st.nextToken());
            int rating2 = Integer.parseInt(st.nextToken());
            int prize1 = getPrize(rating1, ratingTable1, prizeTable1);
            int prize2 = getPrize(rating2, ratingTable2, prizeTable2);
            sb.append((prize1 + prize2)*10000).append("\n");
        }
        System.out.println(sb);
    }

    static int getPrize(int rating, int[] ratingTable, int[] prizeTable) {
        if (rating == 0 || rating > ratingTable[ratingTable.length - 1]) return 0;
        for (int i = 1; i < ratingTable.length; i++) {
            if (rating > ratingTable[i - 1] && rating <= ratingTable[i]) {
                return prizeTable[i];
            }
        }
        return Integer.MIN_VALUE;
    }

}