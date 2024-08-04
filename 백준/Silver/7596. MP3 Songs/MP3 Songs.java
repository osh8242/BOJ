import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int index = 1;
        int N;
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            String[] songs = new String[N];
            for (int i = 0; i < N; i++) {
                songs[i] = br.readLine();
            }
            Arrays.sort(songs);
            sb.append(index++).append("\n");
            for (String song : songs) {
                sb.append(song).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
