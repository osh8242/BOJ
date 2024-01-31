import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][][] pictures = new char[N][5][7];
        for (int n = 0; n < N; n++) {
            for (int i = 0; i < 5; i++) {
                char[] line = br.readLine().toCharArray();
                pictures[n][i] = line;
            }
        }
        StringBuilder sb = null;
        int maxSamePoint = -1;
        for(int i = 0 ; i < N - 1; i ++){
            for(int j = i +1 ; j < N ; j++){
                int countSamePoint = countSamePoint(pictures[i], pictures[j]);
                if(countSamePoint > maxSamePoint){
                    maxSamePoint = countSamePoint;
                    sb = new StringBuilder();
                    sb.append(i+1).append(" ").append(j+1);
                }
            }
        }
        System.out.println(sb);
    }

    static int countSamePoint(char[][] chars1, char[][] chars2){
        int result = 0;
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 7 ; j++){
                if(chars1[i][j] == chars2[i][j])
                    result++;
            }
        }
        return result;
    }

}