import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int line = 1; line <= 3; line++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            int startTime = Integer.parseInt(start.replaceAll(":", ""));
            int endTime = Integer.parseInt(end.replaceAll(":", ""));

            int count = 0;
            while (startTime != endTime) {
                if (startTime % 3 == 0) count++;
                startTime = getNextTime(startTime);
            }
            if (endTime % 3 == 0) count++;
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static int getNextTime(int time) {
        int hour = time / 10000;
        int minute = time % 10000 / 100;
        int second = time % 100;

        second++;
        if (second == 60) {
            second = 0;
            minute++;
        }
        if (minute == 60) {
            minute = 0;
            hour++;
        }
        if (hour == 24) {
            hour = 0;
        }
        return hour * 10000 + minute * 100 + second;
    }
}