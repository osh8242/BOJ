import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("*")) {
            StringTokenizer st = new StringTokenizer(input);
            boolean isTautogram = true;
            char ch = Character.toLowerCase(st.nextToken().charAt(0));
            while (st.hasMoreTokens()) {
                char temp = Character.toLowerCase(st.nextToken().charAt(0));
                if (ch != temp) {
                    isTautogram = false;
                    break;
                }
            }
            sb.append(isTautogram ? 'Y' : 'N').append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
