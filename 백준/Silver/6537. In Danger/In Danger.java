import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] pow10 = {1,10,100,1000,10000,100000,1000000};
        String s;
        while ((s = br.readLine()) != null) {
            if (s.equals("00e0")) break;
            int tens = Integer.parseInt(s.substring(0, 2));
            int z = Integer.parseInt(s.substring(3));
            int n = tens * pow10[z];
            int h = Integer.highestOneBit(n);
            int ans = 2 * (n - h) + 1;
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
