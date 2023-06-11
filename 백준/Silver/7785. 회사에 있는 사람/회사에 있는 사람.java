import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> ts = new TreeSet<>();
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(!ts.add(name)) ts.remove(name);
        }
        StringBuilder sb = new StringBuilder();
        for(String name : ts.descendingSet()){
            sb.append(name+"\n");
        }
        System.out.println(sb);

    }

}
