import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int carPrice = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            while(N-->0){
                StringTokenizer st =new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int price = Integer.parseInt(st.nextToken());
                carPrice += num * price;
            }
            sb.append(carPrice).append("\n");
        }
        System.out.println(sb);
    }

}