import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int duration = Integer.parseInt(br.readLine());

        s += duration%60;
        if (s>=60) {
            s -= 60;
            m++;
        }
        duration -= duration%60;
        duration /= 60;

        m += duration%60;
        if(m>=60){
            m -= 60;
            h++;
        }
        duration -= duration%60;
        duration /= 60;

        h += duration;
        while(h>=24){
            h -= 24;
        }
        System.out.println(h+" "+m+" "+s);

    }//main(){}

}//class Main{}
