import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while (!(line = br.readLine()).equals("0 W 0")) {
            StringTokenizer st = new StringTokenizer(line);
            int deposit = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            int quantity = Integer.parseInt(st.nextToken());
            if (type.equals("W")) quantity = -quantity;
            if (deposit + quantity < -200) {
                sb.append("Not allowed");
            } else {
                sb.append(deposit + quantity);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
