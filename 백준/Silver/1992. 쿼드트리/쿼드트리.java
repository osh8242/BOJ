import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int n;
    public static boolean[][] map;
    public static StringBuilder sb = new StringBuilder();;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new boolean[n+1][n+1];
        for(int i = 1 ; i <= n ; i++){
            String line = br.readLine();
            for( int j = 1 ; j <= n ; j++){
                if(line.charAt(j-1) == '1') map[i][j] = true;
            }
        }
        run(1,1,n);
        System.out.println(sb.toString());
    }

    public static int isComppressable(int startX, int startY, int length){
        for(int i = startX ; i < startX+length ; i++){
            for(int j = startY ; j < startY+length ; j++){
                if(map[i][j] != map[startX][startY]) return -1;
            }
        }
        return map[startX][startY]?1:0;
    }

    public static void run(int startX, int startY, int length){
        switch (isComppressable(startX, startY, length)){
            case -1:
                sb.append("(");
                run(startX, startY, length/2);
                run(startX, startY + length/2, length/2);
                run(startX + length/2, startY, length/2);
                run(startX + length/2, startY + length/2, length/2);
                sb.append(")");
                break;
            case 0:
                sb.append("0"); break;
            case 1:
                sb.append("1");
        }
    }

}
