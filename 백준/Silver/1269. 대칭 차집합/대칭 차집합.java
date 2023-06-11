import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> ts = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            ts.add(Integer.parseInt(st.nextToken()));
        }
        int count = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            if(!ts.add(Integer.parseInt(st.nextToken()))) count++;
        }
        System.out.println(n+m-count*2);

    }

}
