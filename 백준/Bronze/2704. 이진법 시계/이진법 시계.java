import java.io.*;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ":");
            String hour = parseBinary(st.nextToken());
            String minute = parseBinary(st.nextToken());
            String second = parseBinary(st.nextToken());
            for (int i = 0; i < 6; i++) {
                sb.append(hour.charAt(i)).append(minute.charAt(i)).append(second.charAt(i));
            }
            sb.append(" ");
            sb.append(hour).append(minute).append(second).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static String parseBinary(String hour) {
        StringBuilder answer = new StringBuilder();
        int h = Integer.parseInt(hour);
        while(h > 0) {
            answer.insert(0, h % 2);
            h /= 2;
        }
        answer.insert(0, "0".repeat(6-answer.length()));
        return answer.toString();
    }

}
