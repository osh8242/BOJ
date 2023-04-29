import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1 ; test_case <= T ; test_case++){
            int num = Integer.parseInt(br.readLine());
            HashMap<String, ArrayList<String>> hm = new HashMap<>();
            for(int i = 1 ; i <= num ; i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String part = st.nextToken();
                if(!hm.containsKey(part)){
                    hm.put(part, new ArrayList<String>());
                    hm.get(part).add(name);
                } else hm.get(part).add(name);
            }
            int comb = 1;
            for(String str : hm.keySet()){
                comb *= (hm.get(str).size()+1);
            }
            sb.append((comb-1)+"\n");
        }
        System.out.println(sb.toString());
    }
}
