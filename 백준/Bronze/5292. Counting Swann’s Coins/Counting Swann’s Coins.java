import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= N; i++) {
            int residue3 = i % 3;
            int residue5 = i % 5;
            if (residue3 == 0 && residue5 == 0) {
                sb.append("DeadMan").append('\n');
            } else if (residue3 == 0) {
                sb.append("Dead").append('\n');
            } else if (residue5 == 0) {
                sb.append("Man").append('\n');
            } else {
                sb.append(i).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
