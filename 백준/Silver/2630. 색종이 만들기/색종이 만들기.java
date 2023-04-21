import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] map;
    static int blueCount = 0;
    static int whiteCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new boolean[n+1][n+1];
        for (int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++){
                if(st.nextToken().equals("1")) map[i][j] = true;
            }
        }
//        for(boolean[] bs : map){
//            System.out.println(Arrays.toString(bs));
//        }
        run(1,1,n);
        sb.append(whiteCount+"\n");
        sb.append(blueCount+"\n");
        System.out.println(sb.toString());


    }

    public static void run(int start_i, int start_j, int width){
        if(isAllBlue(start_i,start_j,width)){
            blueCount++;
        } else if(isAllWhite(start_i,start_j,width)){
            whiteCount++;
        } else {
            run(start_i,start_j,width/2);
            run(start_i + width/2,start_j,width/2);
            run(start_i,start_j + width/2,width/2);
            run(start_i + width/2,start_j + width/2,width/2);
        }

    }

    public static boolean isAllBlue(int i , int j , int width){
        for(int row = i ; row < i+width ; row++){
            for(int col = j ; col < j+width ; col++){
                if(map[row][col] == false) return false;
            }
        }
        return true;
    }

    public static boolean isAllWhite(int i , int j , int width){
        for(int row = i ; row < i+width ; row++){
            for(int col = j ; col < j+width ; col++){
                if(map[row][col] == true) return false;
            }
        }
        return true;
    }
}