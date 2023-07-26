import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= test_case ; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(r<e-c) sb.append("advertise\n");
            else if (r>e-c) sb.append("do not advertise\n");
            else sb.append("does not matter\n");
        }
        System.out.println(sb);
    }
}
