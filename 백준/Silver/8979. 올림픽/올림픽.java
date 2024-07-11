
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Medal[] medals = new Medal[N + 1];
        for (int i = 1; i <= N; i++) {
            Medal medal = parseMedal(br.readLine());
            medals[medal.id] = medal;
        }

        int rank = 1;
        Medal comparator = medals[K];
        for (int i = 1; i <= N; i++) {
            if (comparator.compareTo(medals[i]) > 0) rank++;
        }
        
        bw.write(String.valueOf(rank));
        bw.flush();
    }

    static Medal parseMedal(String line) {
        StringTokenizer st = new StringTokenizer(line);
        return new Medal(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        );
    }

    static class Medal {
        private final int id;
        private final int gold;
        private final int silver;
        private final int bronze;

        public Medal(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int compareTo(Medal o) {
            if (this.gold != o.gold) return Integer.compare(o.gold, this.gold);
            if (this.silver != o.silver) return Integer.compare(o.silver, this.silver);
            return Integer.compare(o.bronze, this.bronze);
        }
    }

}
