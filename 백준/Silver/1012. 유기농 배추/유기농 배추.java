import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[][] farm;
	private static int[] position;
	private static int m; 
	private static int n;
	private static int k;
	private static int worms;
	private static boolean isRemain;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1 ; test <= T ; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			farm = new int[m][n];
			worms = 0;
			position = new int[]{0, 0};
			for (int i = 1 ; i <= k ; i++) {
				st = new StringTokenizer(br.readLine());
				farm[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			isRemain = true;
			while(isRemain) {
				findVegetablePos();
				searchGroup(position[0], position[1]);
			}
			sb.append(worms+"\n");
		}		
		System.out.println(sb.toString());
	}
	
	public static void findVegetablePos() {
		for (int i = 0 ; i < m ; i++) {
			for (int j = 0 ; j < n ; j++) {
				if(farm[i][j] == 1) {
					position[0] = i;
					position[1] = j;					
					worms++;
					return;
				}
			}
		}
		isRemain = false;
	}
	
	public static void searchGroup(int i, int j) {
		if(farm[i][j] == 1) {farm[i][j] = -worms;}
		if(i < m-1 && farm[i+1][j]==1) {
			searchGroup(i+1, j);
		}
		if(j < n-1 && farm[i][j+1]==1) {
			searchGroup(i, j+1);
		}
		if(i > 0 && farm[i-1][j]==1){
			searchGroup(i-1, j);
		}
		if(j > 0 && farm[i][j-1]==1){
			searchGroup(i, j-1);
		}
	}
	
}