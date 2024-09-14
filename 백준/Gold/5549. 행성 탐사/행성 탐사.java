import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int M, N, K;
    static Record[][] records;

    public static void main(String[] args) throws IOException {
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            records = new Record[M + 1][N + 1];
            for (int i = 0; i <= M; i++) {
                for (int j = 0; j <= N; j++) {
                    records[i][j] = new Record();
                }
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            String input = br.readLine();
            for (int j = 1; j <= N; j++) {
                char type = input.charAt(j - 1);
                records[i][j].j = records[i - 1][j].j + records[i][j - 1].j - records[i - 1][j - 1].j;
                records[i][j].o = records[i - 1][j].o + records[i][j - 1].o - records[i - 1][j - 1].o;
                records[i][j].i = records[i - 1][j].i + records[i][j - 1].i - records[i - 1][j - 1].i;
                records[i][j].add(type);
            }
        }

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int j = records[x2][y2].j - records[x2][y1 - 1].j - records[x1 - 1][y2].j + records[x1 - 1][y1 - 1].j;
            int o = records[x2][y2].o - records[x2][y1 - 1].o - records[x1 - 1][y2].o + records[x1 - 1][y1 - 1].o;
            int i = records[x2][y2].i - records[x2][y1 - 1].i - records[x1 - 1][y2].i + records[x1 - 1][y1 - 1].i;
            sb.append(j).append(" ").append(o).append(" ").append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static class Record {
        int j = 0;
        int o = 0;
        int i = 0;

        void add(char type) {
            switch (type) {
                case 'J' -> j++;
                case 'O' -> o++;
                case 'I' -> i++;
            }
        }

    }

}