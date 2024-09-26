import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            double H = Double.parseDouble(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            sb.append(String.format("%.2f\n", H / P));
        }
           
        System.out.print(sb);
    }

}
