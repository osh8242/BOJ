import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int sHour = Integer.parseInt(st.nextToken());
        int sMin = Integer.parseInt(st.nextToken());
        int sSec = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), ":");
        int eHour = Integer.parseInt(st.nextToken());
        int eMin = Integer.parseInt(st.nextToken());
        int eSec = Integer.parseInt(st.nextToken());

        int sec = eSec - sSec;
        if (sec < 0) {
            sec += 60;
            eMin--;
        }
        int min = eMin - sMin;
        if (min < 0) {
            min += 60;
            eHour--;
        }
        int hour = eHour - sHour;
        if (hour < 0) {
            hour += 24;
        }
        if(sec == 0 && min == 0 && hour == 0) hour = 24;
        
        sb.append(appendZero(hour)).append(":")
          .append(appendZero(min)).append(":")
          .append(appendZero(sec));
        bw.write(sb.toString());
        bw.flush();
    }

    static String appendZero(int t){
        return t < 10 ? "0" + t : String.valueOf(t);
    }

}
