import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<>();
		int[] numList = new int[t];
		int maxCount = 0;
		int maxKey = 0;
		int sum = 0;
		for (int test = 0 ; test < t ; test ++ ) {
			int temp = Integer.parseInt(br.readLine());
			sum += temp;
			numList[test] = temp;
			if(!hm.containsKey(temp)) {
				hm.put(temp, 1);
				if(maxCount < hm.get(temp)) {
					maxCount = hm.get(temp);
					maxKey = temp;
				}
			} else {
				hm.put(temp, hm.get(temp)+1);
				if(maxCount < hm.get(temp)) {
					maxCount = hm.get(temp);
					maxKey = temp;
				}
			}			
		}
		ArrayList<Integer> nums = new ArrayList<>();
		for (int key : hm.keySet()) {
			if(hm.get(key)==maxCount) {
				nums.add(key);
			}
		}		
		Collections.sort(nums);		
		if(nums.size()>1) {
			maxKey = nums.get(1);
		} else {
			maxKey = nums.get(0);
		}
		Arrays.sort(numList);
		
		sb.append(Math.round(((double)sum/t))+"\n");
		sb.append(numList[numList.length/2]+"\n");
		sb.append(maxKey+"\n");	
		sb.append(numList[t-1]-numList[0]+"\n");
		System.out.println(sb.toString());
		
	}
}