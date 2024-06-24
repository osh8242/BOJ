import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = N; i > 0; i--) {
            sb.append(i).append(" ").append(getBottles(i)).append(" of beer on the wall, ")
                    .append(i).append(" ").append(getBottles(i)).append(" of beer.\n")
                    .append("Take one down and pass it around, ").append(i - 1 == 0 ? "no more" : i - 1).append(" ").append(getBottles(i - 1)).append(" of beer on the wall.\n\n");
        }
        sb.append("No more bottles of beer on the wall, no more bottles of beer.\n")
                .append("Go to the store and buy some more, ").append(N).append(" ").append(getBottles(N)).append(" of beer on the wall.\n");

        System.out.print(sb.toString());
    }

    private static String getBottles(int n) {
        if (n == 1) return "bottle";
        else if (n == 0) return "bottles";
        else return "bottles";
    }
}
