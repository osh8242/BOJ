import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static final String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        while(month-->1){
            switch(month){
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    day += 31;
                    break;
                case 4: case 6: case 9: case 11:
                    day += 30;
                    break;
                case 2:
                    day += 28;
                    break;
            }
        }
        System.out.println(days[day%7]);
    }
}
