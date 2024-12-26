import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        if (a != 8 && a != 9) sb.append("answer");
        else {
            int b = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());
            if (b != c) sb.append("answer");
            else {
                int d = Integer.parseInt(br.readLine());
                if (d != 8 && d != 9) sb.append("answer");
            }
        }
        if (sb.length() == 0) sb.append("ignore");
        bw.write(sb.toString());
        bw.flush();
    }
}
