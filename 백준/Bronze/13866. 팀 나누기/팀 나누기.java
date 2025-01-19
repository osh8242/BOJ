import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] level = new int[4];
        for (int i = 0; i < 4; i++) level[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(level);
        System.out.println(Math.abs(level[3] + level[0] - level[1] - level[2]));
    }
}
