import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] gandalf = {1, 2, 3, 3, 4, 10};
    static final int[] sauron = {1, 2, 2, 2, 3, 5, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gandalfPoint = 0;
            for (int i = 0; i < gandalf.length; i++) {
                gandalfPoint += gandalf[i] * Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int sauronPoint = 0;
            for (int i = 0; i < sauron.length; i++) {
                sauronPoint += sauron[i] * Integer.parseInt(st.nextToken());
            }
            sb.append("Battle ").append(t).append(": ")
                    .append(gandalfPoint > sauronPoint ? "Good triumphs over Evil" :
                            gandalfPoint == sauronPoint ? "No victor on this battle field" :
                                    "Evil eradicates all trace of Good")
                    .append("\n");
        }
        System.out.println(sb);
    }

}