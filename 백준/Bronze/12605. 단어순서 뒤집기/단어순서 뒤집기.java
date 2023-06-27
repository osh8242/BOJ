import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1 ; test_case <= T ; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<String> stack = new Stack<>();
            while(st.hasMoreTokens()){
                stack.push(st.nextToken());
            }
            sb.append("Case #"+test_case+": ");
            while(!stack.isEmpty()){
                sb.append(stack.pop()+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

}
