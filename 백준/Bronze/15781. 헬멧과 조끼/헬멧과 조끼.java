import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int helm = 0;
        int armor = 0;
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int current = Integer.parseInt(st.nextToken());
            if(current > helm) helm = current;
        }

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int current = Integer.parseInt(st.nextToken());
            if(current > armor) armor = current;
        }

        System.out.println(helm + armor);
    }

}