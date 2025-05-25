import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int total = Integer.parseInt(st.nextToken());
            int gas = Integer.parseInt(st.nextToken());
            int food = Integer.parseInt(st.nextToken());

            int stops = 0;
            for (int mile = 1; mile < total; mile++) {
                boolean stopGas = (mile % gas == 0);
                boolean stopFood = (mile % food == 0);
                if (stopGas || stopFood) {
                    stops++;
                }
            }

            output.append(total).append(' ').append(gas).append(' ').append(food).append('\n');
            output.append(stops).append('\n');
        }
        System.out.print(output.toString());
    }
}
