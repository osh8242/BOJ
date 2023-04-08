import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[][] map;
	private static int n, m, min, max, block, goal;
	private static int blockCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		block = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		min = 257;
		max = -1;
		
		for(int i = 0 ; i <n ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j <m ; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp < min) min = temp;
				if(temp > max) max = temp;
			}
		}
		int totalTime = 64000001;
		for(int i = max ; i >= min ; i--) {
			blockCount = block;
			int temp = totalTime(i);
			if(totalTime>temp && blockCount >= 0) {
				totalTime = temp;
				goal = i;
			}
		}
		System.out.println(totalTime+" "+goal);
			
	}
	
	public static int measureTimeAtPoint (int current, int goal) {
		if(goal>=current) {			
				blockCount -= goal-current;
				return (goal-current);

		} else {
			blockCount += current-goal;
			return (current-goal)*2;
		}
	}
	
	public static int totalTime (int goal) {
		int answer = 0;
		for(int i = 0 ; i <n ; i++) {
			for (int j = 0 ; j <m ; j++) {
				answer += measureTimeAtPoint(map[i][j], goal);
			}
		}
		return answer;
	}
}