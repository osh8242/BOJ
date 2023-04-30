import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int[][] map; //nxn 맵
    public static boolean[][] isVisit; //방문기록
    public static int n; // 맵 한변의 길이
    public static int sharkLevel = 2; // 상어초기 레벨2
    public static int eatFishCount = 0; // 먹은 물고기 수
    public static int[] sharkPosition; //상어위치
    public static int targetDistance; //목표물 거리
    public static int time; //총 걸린 시간
    public static Queue<int[]> bfs = new LinkedList<>(); //탐색 위치를 담는 bfs 큐
    public static int[] dRow = {-1, 0, 0, 1}; //행 탐색범위
    public static int[] dCol = {0, -1, 1, 0}; //열 탐색범위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //초기맵 세팅
        n = Integer.parseInt(br.readLine());
        map = new int[n+2][n+2];
        isVisit = new boolean[n+2][n+2];
        for(int j=0 ; j <=n+1 ; j++ ){
            map[0][j] = -1;
            map[n+1][j] = -1;
            map[j][0] = -1;
            map[j][n+1] = -1;
        }
        //초기맵 입력, 상어위치, 물고기위치 입력
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= n ; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num != 0){
                    map[i][j] = num;
                    if(num == 9) sharkPosition = new int[]{i,j};
                }

            }
        }
        //물고기 탐색
        while (true) {
            bfs.add(new int[]{sharkPosition[0],sharkPosition[1], 0}); //상어위치입력
            targetDistance = n*n; //타겟거리 최대로 초기화
            isVisit = new boolean[n+2][n+2]; //방문기록 초기화
            isVisit[sharkPosition[0]][sharkPosition[1]] = true; //상어초기위치 방문표시
            while(bfs.size() != 0){ //타겟 탐색
                int[] temp = bfs.poll();
                searchFish(temp[0], temp[1], temp[2]);
            }
            map[sharkPosition[0]][sharkPosition[1]] = 9; // 변경된 상어위치 기록
            eatFishCount++; // 먹은 물고기수 ++
            if(eatFishCount == sharkLevel && sharkLevel < 7) { // 먹은 물고기수로 상어레벨업
                sharkLevel++;
                eatFishCount = 0;
            }
            if(targetDistance < n*n) time += targetDistance; // 거리에 따른 시간반영
            else break; // 먹을 수 있는 물고기를 못찾았으면 break;
        }
        System.out.println(time); //총 걸린 시간(정답) 출력

    }
    // 물고기 탐색
    public static void searchFish(int x, int y, int distance){
        if(distance > targetDistance) return; //탐색한 위치의 거리가 현재 찾은 물고기와의 거리보다 길면 종료
        if(map[x][y] < sharkLevel && map[x][y] > 0){ //물고기 발견
            targetDistance = distance; //타겟과의 거리
            if(map[sharkPosition[0]][sharkPosition[1]] == 9) { //상어위치가 9이면 첫물고기를 발견한 것이므로 이동예정
                map[sharkPosition[0]][sharkPosition[1]] = 0;
                sharkPosition[0] = x;
                sharkPosition[1] = y;
            }
            if(sharkPosition[0] > x) { // 행번호가 더 작고 열번호가 더 작으면 타겟변경
                sharkPosition[0] = x;
                sharkPosition[1] = y;
            } else if(sharkPosition[0] == x && sharkPosition[1] > y){
                sharkPosition[1] = y;
            }
        }
        distance++; // 물고기를 못찾았으면 거리++;
        for(int d = 0 ; d < 4 ; d++){ //인근 칸을 탐색하여 bfs 큐에 담는다
            if(map[x+dRow[d]][y+dCol[d]] <= sharkLevel && map[x+dRow[d]][y+dCol[d]] > -1 && isVisit[x+dRow[d]][y+dCol[d]] == false){
                isVisit[x+dRow[d]][y+dCol[d]] = true;
                bfs.add(new int[]{x+dRow[d], y+dCol[d], distance});
            }
        }
    }
}
