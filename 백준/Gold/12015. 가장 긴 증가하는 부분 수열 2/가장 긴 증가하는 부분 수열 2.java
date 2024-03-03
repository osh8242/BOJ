import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> dp = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp.add(Integer.parseInt(st.nextToken()));
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            if(value > dp.get(dp.size()-1)) dp.add(value);
            else {
                int left = 0;
                int right = dp.size()-1;
                while(left < right){
                    int mid = (left+right)/2;
                    int midValue = dp.get(mid);
                    if(value > midValue) left = mid+1;
                    else right = mid;
                }
                dp.set(left, value);
            }
        }
        System.out.println(dp.size());
    }
}