import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-+",true);
        int sum = Integer.parseInt(st.nextToken());
        boolean isNegative = false;
        while (st.hasMoreTokens()) {
            char op = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            if(!isNegative && op == '+') sum+=num;
            else if (!isNegative && op == '-') {
                isNegative = !isNegative;
                sum -= num;
            } else{
                sum -= num;
            }

        }
        System.out.println(sum);

    }

}