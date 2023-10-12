import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aa = Integer.parseInt(st.nextToken());
        int ao = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ba = Integer.parseInt(st.nextToken());
        int bo = Integer.parseInt(st.nextToken());
        System.out.println(Math.min(aa + bo, ao + ba));

    }
}
