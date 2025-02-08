import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while (!(input = br.readLine()).equals("0")) {
            int N = Integer.parseInt(input);
            List<String> cards = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String card = br.readLine();
                cards.add(card);
            }
            int bottomIndex = N / 2;
            if (N % 2 == 1) bottomIndex++;
            for (int i = 0; i < N / 2; i++) {
                sb.append(cards.get(i)).append('\n');
                sb.append(cards.get(i + bottomIndex)).append('\n');
            }
            if (N % 2 == 1) sb.append(cards.get(N / 2)).append('\n');
        }
        System.out.println(sb);
    }
}
