import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] papers = new int[n+1][2];
        boolean[][] isBlack;
        int xMax = -1;
        int yMax = -1;
        for(int paper = 1 ; paper <= n ; paper++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            papers[paper][0] = Integer.parseInt(st.nextToken());
            papers[paper][1] = Integer.parseInt(st.nextToken());
            if(papers[paper][0] > xMax) xMax = papers[paper][0];
            if(papers[paper][1] > yMax) yMax = papers[paper][1];
        }
        int count = 0;
        isBlack = new boolean[xMax+11][yMax+11];
        for(int paper = 1 ; paper <= n ; paper++){
            for(int i = papers[paper][0] ; i < papers[paper][0]+10 ; i++){
                for(int j = papers[paper][1] ; j < papers[paper][1]+10 ; j++){
                    if(!isBlack[i][j]) {
                        isBlack[i][j] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);


    }

}