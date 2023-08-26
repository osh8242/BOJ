import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int countOfRefusal = 0;
        boolean[] isSeated = new boolean[101];
        while (n-- > 0) {
            int seatNum = Integer.parseInt(st.nextToken());
            if (!isSeated[seatNum]) isSeated[seatNum] = true;
            else countOfRefusal++;
        }
        System.out.println(countOfRefusal);

    }

}
