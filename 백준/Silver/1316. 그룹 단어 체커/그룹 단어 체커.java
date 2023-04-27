import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();
        int answer = 0;
        for(int test_case = 1 ; test_case <= T ; test_case++){
            String str = br.readLine();
            char prev = str.charAt(0);
            set.add(prev);
            boolean isGroupword = true;
            for(int i = 1 ; i < str.length() ; i++){
                if(str.charAt(i) != prev){
                    if(set.contains(str.charAt(i))){
                        isGroupword = false;
                        break;
                    } else{
                        prev = str.charAt(i);
                        set.add(prev);
                    }
                }
            }
            if(isGroupword) answer++;
            set.clear();
        }
        System.out.println(answer);

    }
}