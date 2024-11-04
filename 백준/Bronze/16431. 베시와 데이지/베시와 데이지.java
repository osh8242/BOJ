import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int jx = Integer.parseInt(st.nextToken());
        int jy = Integer.parseInt(st.nextToken());

        int bCount = Math.max(Math.abs(bx - jx), Math.abs(by - jy));
        int jCount = Math.abs(dx - jx) + Math.abs(dy - jy);
        System.out.println(bCount < jCount ? "bessie" : bCount == jCount ? "tie" : "daisy");

    }


}
