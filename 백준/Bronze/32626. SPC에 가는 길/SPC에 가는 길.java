import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int px = Integer.parseInt(st.nextToken());
        int py = Integer.parseInt(st.nextToken());

        int turns;
        if (sx == ex) {
            if (px == sx && ((sy < py && py < ey) || (ey < py && py < sy))) {
                turns = 2;
            } else {
                turns = 0;
            }
        } else if (sy == ey) {
            if (py == sy && ((sx < px && px < ex) || (ex < px && px < sx))) {
                turns = 2;
            } else {
                turns = 0;
            }
        } else {
            turns = 1;
        }

        System.out.println(turns);
    }
}
