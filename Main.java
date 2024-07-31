import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] menu = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            menu[i] = Integer.parseInt(br.readLine());
        }
        int M = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i <= M; i++) {
            sum += menu[Integer.parseInt(br.readLine())];
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

}
