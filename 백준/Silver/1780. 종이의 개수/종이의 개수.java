import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static byte[][] map;
    static int count1 = 0;
    static int count0 = 0;
    static int count_1 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        map = new byte[n+1][n+1];
        for (int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++){
                switch (st.nextToken().charAt(0)){
                    case '1' :
                        map[i][j] = 1; break;
                    case '0' :
                        map[i][j] = 0; break;
                    default :
                        map[i][j] = -1;

                }
            }
        }
        run(1,1,n);
        sb.append(count_1+"\n");
        sb.append(count0+"\n");
        sb.append(count1+"\n");
        System.out.println(sb.toString());
    }

    public static void run(int start_i, int start_j, int width){
        if(isOne(start_i,start_j,width)){
            count1++;
        } else if(isZero(start_i,start_j,width)){
            count0++;
        } else if(isNOne(start_i,start_j,width)){
            count_1++;
        } else {
            run(start_i, start_j,width/3);
            run(start_i + width/3,start_j,width/3);
            run(start_i + width/3*2,start_j,width/3);

            run(start_i,start_j + width/3,width/3);
            run(start_i + width/3,start_j + width/3,width/3);
            run(start_i + width/3*2,start_j + width/3,width/3);

            run(start_i,start_j + width/3*2,width/3);
            run(start_i + width/3,start_j + width/3*2,width/3);
            run(start_i + width/3*2,start_j + width/3*2,width/3);

        }

    }

    public static boolean isOne(int i , int j , int width){
        for(int row = i ; row < i+width ; row++){
            for(int col = j ; col < j+width ; col++){
                if(map[row][col] != 1) return false;
            }
        }
        return true;
    }

    public static boolean isZero(int i , int j , int width){
        for(int row = i ; row < i+width ; row++){
            for(int col = j ; col < j+width ; col++){
                if(map[row][col] != 0) return false;
            }
        }
        return true;
    }
    public static boolean isNOne(int i , int j , int width){
        for(int row = i ; row < i+width ; row++){
            for(int col = j ; col < j+width ; col++){
                if(map[row][col] != -1) return false;
            }
        }
        return true;
    }
}