import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static StringBuilder sb= new StringBuilder();
    static int n,m;
    static TreeMap<Integer, Integer> tm;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        tm = new TreeMap<>();
        m = Integer.parseInt(st.nextToken());
        arr = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            int n = 1;
            int temp = Integer.parseInt(st.nextToken());
            if(tm.containsKey(temp)) n = tm.get(temp)+1;
            tm.put(temp, n);
        }
        for(int key : tm.keySet()){
            tm.put(key, tm.get(key)-1);
            dfs(key, 1);
            tm.put(key, tm.get(key)+1);
        }
        System.out.println(sb);

    }//main(){}

    static void dfs(int num, int length){
        arr[length] = num;
        if(length == m){
            for(int i = 1 ; i <= m ; i++){
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
        } else {
            for(int key : tm.keySet()){
                tm.put(key, tm.get(key)-1);
                if(tm.get(key) >= 0) dfs(key, length+1);
                tm.put(key, tm.get(key)+1);
            }
        }
    }

}//class Main{}
