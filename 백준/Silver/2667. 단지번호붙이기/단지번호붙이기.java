import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Comparator;


public class Main {

    public static boolean[][] map;
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};

    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> group = new ArrayList<>();
        map = new boolean[n+2][n+2];
        for(int i =1 ; i <= n ; i++){
            String temp = br.readLine();
            for(int j = 1 ; j <= n ; j++){
                if(temp.charAt(j-1) == '1') map[i][j] = true;
            }
        }
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(map[i][j] == true){
                    count = 0;
                    dfs(i,j);
                    group.add(count);
                }
            }
        }
        group.sort(Comparator.naturalOrder());
        for(int num : group){
            sb.append(num+"\n");
        }
        System.out.println(group.size()+"\n"+sb.toString());
    }

    public static void dfs(int i, int j){
        if(map[i][j] == true) {
            map[i][j] = false;
            count++;
        }
        for(int k = 0 ; k < 4 ; k++){
            if(map[i+dr[k]][j+dc[k]] == true) {
                dfs(i+dr[k], j+dc[k]);
            }
        }
    }

}
