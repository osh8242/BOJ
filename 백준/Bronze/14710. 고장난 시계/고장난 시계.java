import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int theta1 = Integer.parseInt(st.nextToken());
        int theta2 = Integer.parseInt(st.nextToken());
        if (theta2 % 6 != 0) {
            System.out.println("X");
            return;
        }
        int m = theta2 / 6;
        int r1 = (2 * theta1) % 60;
        if (r1 == m) System.out.println("O");
        else System.out.println("X");
    }
}
