import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) input[i] = Integer.parseInt(st.nextToken());

        int[] lis = new int[N];
        lis[0] = 1;
        List<Integer> dp = new ArrayList<>();
        dp.add(input[0]);


        for(int i = 1 ; i < N ; i++) {
            if(input[i] > dp.get(dp.size()-1)) {
                dp.add(input[i]);
                lis[i] = dp.size();
            }
            else {
                int left = 0;
                int right = dp.size()-1;
                while(left < right){
                    int mid = (left+right)/2;
                    int midValue = dp.get(mid);
                    if(input[i] > midValue) left = mid+1;
                    else right = mid;
                }
                dp.set(left, input[i]);
                lis[i] = left + 1;
            }
        }
        sb.append(dp.size()).append("\n");

        int btValue = dp.size();
        Stack<Integer> stack = new Stack<>();
        for(int i = N -1 ; i >= 0 ; i--){
            if(lis[i] == btValue) {
                stack.push(input[i]);
                btValue--;
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        System.out.println(sb);
    }
}