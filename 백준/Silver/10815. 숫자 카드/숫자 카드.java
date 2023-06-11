import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> ts = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(n-->0){
            ts.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(m-->0){
            if(ts.contains(Integer.parseInt(st.nextToken()))) sb.append("1 ");
            else sb.append("0 ");
        }
        System.out.println(sb);

    }

}
