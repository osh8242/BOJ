import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static final int[] DAY = {-1,
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            if (day == 0 && month == 0 && year == 0) break;
            int days = 0;
            for (int i = 1; i < month; i++) {
                days += DAY[i];
            }
            days += day;
            if (month > 2 && isYoonYear(year)) days++;
            sb.append(days).append("\n");
        }
        System.out.println(sb);
    }

    static boolean isYoonYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}