import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++) inputs[i] = Integer.parseInt(st.nextToken());

        // dp 시작 세팅
        List<Integer> dp = new ArrayList<>(N); // LIS를 담는 List
        int[] rank = new int[N];// i번째 숫자가 가장 클 떄의 LIS 길이를 담는 배열

        // 초기값 세팅
        dp.add(inputs[0]); // 첫번째 숫자를 dp에 담아준다
        rank[0] = 1; // 첫번째 숫자는 LIS 길이가 1
        int maxRank = 1;

        // dp 시작
        for(int i = 1;  i < N; i++){
            int value = inputs[i];

            // i번째 숫자가 dp의 마지막 값보다 크면 dp에 담고 LIS 길이는 dp 사이즈와 같다
            if(value > dp.get(dp.size()-1)) {
                dp.add(value);
                rank[i] = dp.size();

            // i번째 숫자가 dp 마지막 값보다 작으면
            // dp에 담긴 숫자 중에 i번째 숫자보다 같거나 큰 수들 중 가장 작은 작은 숫자와 치환
            // i번째 숫자가 가장 클때의 LIS 길이는 dp에서 찾은 위치와 같음
            } else {
                int left = 0;
                int right = dp.size()-1;
                while(left<right){
                    int mid = (left+right)/2;
                    int midValue = dp.get(mid);
                    if(value > midValue) left = mid+1;
                    else right = mid;
                }
                dp.set(left, value);
                rank[i] = left+1;
            }
            // 가장 긴 LIS 값과 비교하여 업데이트
            maxRank = Math.max(rank[i], maxRank);
        }
        // 백트래킹 시작
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        sb.append(maxRank).append("\n");
        for(int i = N-1; i >=0 ; i--){
            if(rank[i] == maxRank) {
                stack.push(inputs[i]);
                maxRank--;
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        System.out.println(sb);
    }
}