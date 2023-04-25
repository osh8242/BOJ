import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nums[i] = end;
            if(!hm.containsKey(end)){
                hm.put(end,start);
            } else if (hm.get(end) < start){
                hm.put(end, start);
            }
        }
        Arrays.sort(nums);
        int count = 1;
        int index = nums[0];
        for(int i = 1 ; i < n ; i++) {
            if(hm.get(nums[i]) >= index) {
                count++;
                index = nums[i];
            }
        }
        System.out.println(count);
    }
}
