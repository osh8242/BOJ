import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while (!(input = br.readLine()).equals("0 0 0 0")) {
            String[] tokens = input.split(" ");
            sb.append(Integer.parseInt(tokens[2]) - Integer.parseInt(tokens[1])).append(" ");
            sb.append(Integer.parseInt(tokens[3]) - Integer.parseInt(tokens[0])).append("\n");
        }
        System.out.println(sb);
    }

}