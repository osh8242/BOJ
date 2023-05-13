import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> series = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        series.add(Integer.parseInt(st.nextToken()));
        for(int i = 1 ; i < n ; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num > series.get(series.size()-1)){
                series.add(num);
            } else {
                int left = 0;
                int right = series.size()-1;
                while(left < right){
                    int mid = (left+right)/2;
                    if(num > series.get(mid)){
                        left = mid+1;
                    } else {
                        right = mid;
                    }
                }
                series.set(right, num);
            }
        }
        System.out.println(series.size());

    } // void main()

} //Class Main