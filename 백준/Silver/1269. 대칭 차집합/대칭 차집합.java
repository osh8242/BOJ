import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<Integer> hs = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            hs.add(Integer.parseInt(st.nextToken()));
        }
        int count = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            if(!hs.add(Integer.parseInt(st.nextToken()))) count++;
        }
        System.out.println(n+m-count*2);

    }

}
