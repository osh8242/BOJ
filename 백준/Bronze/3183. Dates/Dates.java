import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(line);
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            boolean valid = true;
            if (month < 1 || month > 12) valid = false;
            else {
                int maxDay;
                switch (month) {
                    case 4: case 6: case 9: case 11:
                        maxDay = 30;
                        break;
                    case 2:
                        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
                            maxDay = 29;
                        else
                            maxDay = 28;
                        break;
                    default:
                        maxDay = 31;
                }
                if (day < 1 || day > maxDay) valid = false;
            }
            System.out.println(valid ? "Valid" : "Invalid");
        }
    }
}
