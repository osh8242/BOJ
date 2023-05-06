import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int T = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= T ; test++){
            int lines = Integer.parseInt(br.readLine());
            for(int line = 1 ; line <= lines ; line++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                switch (command){
                    case 'I' : {
                        int n = 1;
                        if(tm.containsKey(num)) n = tm.get(num)+1;
                        tm.put(num, n);
                        break;
                    }
                    case 'D' : {
                        if(tm.size() == 0) break;
                        switch (num){
                            case 1 : {
                                if((int)tm.get(tm.lastKey()) == 1) tm.remove(tm.lastKey());
                                else tm.put(tm.lastKey(), (int)tm.get(tm.lastKey())-1);
                                break;
                            }
                            case -1 : {
                                if ((int)tm.get(tm.firstKey()) == 1) tm.remove(tm.firstKey());
                                else tm.put(tm.firstKey(), (int)tm.get(tm.firstKey()) - 1);
                                break;
                            }
                        }
                    } break;
                }
            }
            if(tm.size() == 0) sb.append("EMPTY\n");
            else sb.append((int)tm.lastKey() + " " + (int)tm.firstKey() + "\n");
            tm.clear();
        }
        System.out.println(sb.toString());
    } // void main()
} //Class Main