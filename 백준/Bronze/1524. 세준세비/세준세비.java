import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int maxPower = -1;
            char winner = 'S';
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int power = Integer.parseInt(st.nextToken());
                if(power > maxPower) {
                    maxPower = power;
                }
            }
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int power = Integer.parseInt(st.nextToken());
                if(power > maxPower){
                    maxPower = power;
                    winner = 'B';
                }
            }
            sb.append(winner).append("\n");
        }
        System.out.println(sb);
    }
}