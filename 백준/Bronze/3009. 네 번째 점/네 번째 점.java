import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        int x1, x2, y1, y2, x3, y3, x4, y4;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());

        if (x3 == x1) x4 = x2;
        else if(x3 == x2) x4 = x1;
        else x4 = x3;
        if (y3 == y1) y4 = y2;
        else if(y3 == y2) y4 = y1;
        else y4 = y3;

        System.out.println(x4 + " " + y4);
    }


}