import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*농장맵 출력
		StringBuilder sb = new StringBuilder();
		for (int height = 0 ; height < h ; height++) {
			for(int row = 0 ; row < n ; row++) {					
				for(int col = 0 ; col < m ; col++) {
					sb.append(map[row][col][height]+" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
*/

public class Main {
	
	private static int[][][] map;
	private static int m, n, h;
	private static ArrayList<int[]> startPoints;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[n][m][h];
		startPoints = new ArrayList<>();
		for (int height = 0 ; height < h ; height++) {
			for(int row = 0 ; row < n ; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col = 0 ; col < m ; col++) {
					int temp = Integer.parseInt(st.nextToken());
					map[row][col][height] = temp;
					if (temp == 1) {
						startPoints.add(new int[] {row, col, height});
					}
				}
			}
		}
		int day = 1;		
		while(!startPoints.isEmpty()) {
			ArrayList<int[]> temp = new ArrayList<>(startPoints);
			startPoints.clear();
			day++;
			for (int[] point : temp) {
				processStart(point[0], point[1], point[2], day);
			}
			if(startPoints.isEmpty()) {
				day--;
			} 		
		}
		
		if(isExistZero()) {
			System.out.println(-1);
		} else {
			System.out.println(day-1);
		}
		
	}
	
	public static void processStart(int row, int col, int height, int day) {		
		if( row+1 < n && map[row+1][col][height]==0) {
			map[row+1][col][height] = day;
			startPoints.add(new int[] {row+1, col, height});
		}
		if( row-1 >= 0 && map[row-1][col][height]==0 ) {
			map[row-1][col][height] = day;
			startPoints.add(new int[] {row-1, col, height});
		}
		if( col+1 < m && map[row][col+1][height]==0 ) {
			map[row][col+1][height] = day;
			startPoints.add(new int[] {row, col+1, height});
		}
		if( col-1 >= 0 && map[row][col-1][height]==0) {
			map[row][col-1][height] = day;
			startPoints.add(new int[] {row, col-1, height});
		}
		if( height+1 < h && map[row][col][height+1]==0) {
			map[row][col][height+1] = day;
			startPoints.add(new int[] {row, col, height+1});
		}
		if( height-1 >= 0 && map[row][col][height-1]==0) {
			map[row][col][height-1] = day;
			startPoints.add(new int[] {row, col, height-1});
		}
	}
	
	public static boolean isExistZero() {
		for (int height = 0 ; height < h ; height++) {
			for(int row = 0 ; row < n ; row++) {				
				for(int col = 0 ; col < m ; col++) {
					if (map[row][col][height]==0) {
						return true;
					}
				}
			}
		}
		return false;
	}

}