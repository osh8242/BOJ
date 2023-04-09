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
		m = Integer.parseInt(st.nextToken()); //열
		n = Integer.parseInt(st.nextToken()); //행
		h = Integer.parseInt(st.nextToken()); //높이
		map = new int[n][m][h]; //농장창고 배열
		startPoints = new ArrayList<>(); // 익은 토마토의 위치를 담는 리스트
		for (int height = 0 ; height < h ; height++) { //농장창고 구현
			for(int row = 0 ; row < n ; row++) {
				st = new StringTokenizer(br.readLine());
				for(int col = 0 ; col < m ; col++) {
					int temp = Integer.parseInt(st.nextToken());
					map[row][col][height] = temp;
					if (temp == 1) { // 익은 토마토라면 시작위치 리스트에 담기
						startPoints.add(new int[] {row, col, height});
					}
				}
			}
		}
		int day = 1; // 첫째날		
		while(!startPoints.isEmpty()) { // 다음 탐색위치가 없을 때까지 반복
			ArrayList<int[]> temp = new ArrayList<>(startPoints);
			startPoints.clear(); // temp 리스트에 탐색시작 위치를 전달 후 내용 비움
            day++;
			for (int[] point : temp) { // 탐색 위치로부터 다음날 익은 토마토 탐색
				processStart(point[0], point[1], point[2], day);
			}
			if(startPoints.isEmpty()) { // 다음 탐색위치가 없으면 전날에 이미 다 익었다는 의미이므로 day--;
				day--;
			} 		
		}
		
		if(isExistZero()) { // 탐색이 끝났는데도 익지않은 토마토가 있다면 -1 리턴
			System.out.println(-1);
		} else { // 문제는 몇일차에 다 익었느냐가 아니라 몇일이 걸렸느냐이므로 day-1 을 리턴
			System.out.println(day-1);
		}
		
	}
	
    //익은 토마토 주변을 탐색(상,하,좌,우,위,아래)하고 다음 탐색위치 리스트에 등록
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
	
    // 농장에 익지않은 토마토가 있는지 탐색
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