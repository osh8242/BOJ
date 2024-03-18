import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stars = new char[N][2*N-1];
        for(char[] chars : stars){
            Arrays.fill(chars,' ');
        }
        printStars(0,N-1,N);
        StringBuilder sb = new StringBuilder();
        for(char[] chars : stars){
            sb.append(new String(chars)).append("\n");
        }
        System.out.println(sb);
    }

    static void printStars(int i, int j, int N){
        if(N==3){
            stars[i][j]='*';
            stars[i+1][j-1]=stars[i+1][j+1]='*';
            stars[i+2][j-2]=stars[i+2][j-1]=stars[i+2][j]=stars[i+2][j+1]=stars[i+2][j+2]='*';
            return;
        }

        int nextSize=N/2;
        printStars(i,j,nextSize);
        printStars(i+nextSize,j-nextSize,nextSize);
        printStars(i+nextSize,j+nextSize,nextSize);
    }

}
