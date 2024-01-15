import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] input = new int[N+1][6];
        for(int i = 1 ; i <= N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= 5 ; j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 1 ; i <= N ; i++) map.put(i, new HashSet<>());
        for(int j = 1 ; j <= 5 ; j++){
            for(int i = 1 ; i < N ; i++){
                for(int k = i+1 ; k <= N ; k++){
                    if(input[i][j] == input[k][j]){
                        map.get(i).add(k);
                        map.get(k).add(i);
                    }
                }
            }
        }
        int max = -1;
        int president = -1;
        for(int student : map.keySet()){
            int count = map.get(student).size();
            if(max < count) {
                max = count;
                president = student;
            }
        }
        System.out.println(president);

    }

}