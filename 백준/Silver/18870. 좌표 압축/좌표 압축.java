import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(!tm.containsKey(temp)){
                tm.put(temp, new ArrayList<>());
                tm.get(temp).add(i);
            } else tm.get(temp).add(i);
        }
        int[] nums = new int[n];
        int i = 0;
        for(ArrayList<Integer> al : tm.values()){
            for(int num : al){
                nums[num] = i;
            }
            i++;
        }
        for(int j = 0; j < n ; j++){
            sb.append(nums[j]+" ");
        }
        System.out.println(sb.toString());
    }
}
