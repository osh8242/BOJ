import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> dic = new HashMap<>();
        String[] list = new String[n+1];
        for (int i = 1 ; i <= n ; i++){
            String temp = br.readLine();
            dic.put(temp,i);
            list[i] = temp;
        }
        for (int i = 1 ; i <= m ; i++){
            String temp = br.readLine();
            if(temp.charAt(0) >= 'A'){
                sb.append(dic.get(temp)+"\n");
            } else {
                sb.append(list[Integer.parseInt(temp)]+"\n");
            }
        }
        System.out.println(sb.toString());
    }

}