import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer> dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp.add(Integer.parseInt(st.nextToken()));
        for(int i = 2 ; i <= n ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num>dp.get(dp.size()-1)) dp.add(num);
            else binarySearch(num);
        }
        System.out.println(dp.size());
    }

    static void binarySearch(int num){
        int left = 0;
        int right = dp.size()-1;
        while(left < right){
            int mid = (left+right)/2;
            if(num > dp.get(mid)){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        dp.set(left,num);
    }

}
