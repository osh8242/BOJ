import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1 ; test_case <= T ; test_case++){
            int n = Integer.parseInt(br.readLine());
            String[] mbtiList = new String[n];
            int minDistance = Integer.MAX_VALUE;
            HashMap<String, Integer> hm = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                mbtiList[i] = st.nextToken();
                int count = 1;
                if(hm.containsKey(mbtiList[i])) count = hm.get(mbtiList[i])+1;
                hm.put(mbtiList[i], count);
                if(hm.get(mbtiList[i])==3){
                    minDistance = 0;
                    break;
                }
                for(int j = 0 ; j < i-1 ; j++){
                    for(int k = j+1 ; k < i ; k++){
                        int distance = getDistance(mbtiList[i],mbtiList[j],mbtiList[k]);
                        if(distance < minDistance) minDistance = distance;
                    }
                }

            }
            sb.append(minDistance+"\n");
        }
        System.out.println(sb);

    }

    static int getDistance(String a, String b, String c){
        return getDistance(a,b)+getDistance(b,c)+getDistance(c,a);
    }
    static int getDistance(String a, String b){
        int distance = 0;
        for(int i = 0 ; i < 4 ; i++) {if(a.charAt(i) != b.charAt(i)) distance++;}
        return distance;
    }

}
