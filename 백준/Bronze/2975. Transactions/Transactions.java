import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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
        System.out.println(sb);
    }

}
