import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long N, answer;

    public static void main(String[] args) throws IOException {
        N = Long.parseLong(br.readLine());
        answer = -1;
        long q = N / 5;
        int r = (int) N % 5;
        switch (r) {
            case 0 -> answer = q;
            case 1 -> {if (q > 0) answer = q + 1;}
            case 2 -> {if (q > 1) answer = q + 2;}
            case 3 -> answer = q + 1;
            case 4 -> {if (q > 0) answer = q + 2;}
        }
        bw.write(Long.toString(answer));
        bw.flush();
    }

}
