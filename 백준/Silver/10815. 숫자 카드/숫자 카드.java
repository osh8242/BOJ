import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] hasCard = new boolean[20000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-->0){
            hasCard[Integer.parseInt(st.nextToken())+10000000] = true;
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m-->0){
            if(hasCard[Integer.parseInt(st.nextToken())+10000000]) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.println(sb);

    }

}
