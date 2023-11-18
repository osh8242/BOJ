import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num = -1;
            if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken());
            switch (command){
                case "add" : set.add(num); break;
                case "remove" : set.remove(num); break;
                case "check" : sb.append(set.contains(num) ? "1" : "0").append("\n"); break;
                case "toggle" : if(set.contains(num)) set.remove(num); else set.add(num); break;
                case "all" : for(int i = 1 ; i <= 20 ; i++) set.add(i); break;
                case "empty" : set.clear();
            }
        }
        System.out.println(sb);

    }

}
