import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            int durationInSeconds = getDurationInSeconds(input);

            int hours = durationInSeconds / 3600;
            durationInSeconds %= 3600;
            int minutes = durationInSeconds / 60;
            int seconds = durationInSeconds % 60;

            sb.append(hours).append(" ").append(minutes).append(" ").append(seconds).append("\n");
        }
        System.out.println(sb);
    }

    private static int getDurationInSeconds(String[] input) {
        int startHour = Integer.parseInt(input[0]);
        int startMin = Integer.parseInt(input[1]);
        int startSec = Integer.parseInt(input[2]);
        int endHour = Integer.parseInt(input[3]);
        int endMin = Integer.parseInt(input[4]);
        int endSec = Integer.parseInt(input[5]);

        int startInSeconds = startHour * 3600 + startMin * 60 + startSec;
        int endInSeconds = endHour * 3600 + endMin * 60 + endSec;
        return endInSeconds - startInSeconds;
    }
}
