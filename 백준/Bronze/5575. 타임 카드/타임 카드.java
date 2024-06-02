import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Time {
        private int hour;
        private int min;
        private int sec;

        public Time(int hour, int min, int sec) {
            this.hour = hour;
            this.min = min;
            this.sec = sec;
        }

        public Time getDuration(Time end) {
            int sec = 0;
            int min = 0;
            int hour = 0;
            sec += end.sec - this.sec;
            if (sec < 0) {
                sec += 60;
                min--;
            }
            min += end.min - this.min;
            if (min < 0) {
                min += 60;
                hour--;
            }
            hour += end.hour - this.hour;
            return new Time(hour, min, sec);
        }

        public String toString(){
            return String.format("%d %d %d", hour, min, sec);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            Time start = new Time(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            Time end = new Time(Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5]));
            Time duration = start.getDuration(end);
            System.out.println(duration);
        }
    }

}
