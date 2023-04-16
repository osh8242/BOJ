import java.io.*;
import java.util.*;

public class Main {	
	
	static int day = 0;
	static int[] dr = new int[] {1, -1, 0, 0};
	static int[] dc = new int[] {0, 0, 1, -1};
	static boolean[][] map;
	static Queue<int[]> que;
	static int m, n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new boolean[n+2][m+2];
		que = new LinkedList<>();
		for(int i = 1 ; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j <= m ; j++) {
				switch(Integer.parseInt(st.nextToken())) {
					case 0 :
						map[i][j] = true;
						break;
					case 1 :						
						que.add(new int[] {i,j});				
				}
			}
		}
		while(!que.isEmpty()) {
			Queue<int[]> temp = new LinkedList<>(que);
			que.clear();
			dayThrou(temp);
		}
		if(isExistZero()) {System.out.println(-1); return;}
		else System.out.println(day);		
	}	
	
	public static void dayThrou(Queue<int[]> temp) {
		for(int[] arr : temp) {
			for (int i = 0 ; i < 4 ; i++) {
				if(map[arr[0]+dr[i]][arr[1]+dc[i]] == true) {
					que.add(new int[] {arr[0]+dr[i], arr[1]+dc[i]});
					map[arr[0]+dr[i]][arr[1]+dc[i]] = false;
				}
			}		
		}
		if(!que.isEmpty()) day++;
	}
	
	public static boolean isExistZero() {
		for(int i = 1 ; i <= n ; i++) {
			for (int j = 1 ; j <= m ; j++ ) {
				if(map[i][j] == true) return true;
			}
		}
		return false;
	}		
}