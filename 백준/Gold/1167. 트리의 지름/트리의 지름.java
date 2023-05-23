import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisit;
    static int maxDistance = 0;
    static int nodeNum, endNode;
    static HashMap<Integer, Integer>[] connections;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeNum = Integer.parseInt(br.readLine());
        connections = new HashMap[nodeNum+1];
        isVisit = new boolean[nodeNum+1];
        for(int line = 1 ; line <= nodeNum ; line++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pNode = Integer.parseInt(st.nextToken());
            int cNode = Integer.parseInt(st.nextToken());
            while(cNode != -1){
                int distance = Integer.parseInt(st.nextToken());
                if(connections[pNode] == null){
                    HashMap<Integer, Integer> hm = new HashMap<>();
                    hm.put(cNode, distance);
                    connections[pNode] = hm;
                } else {
                    connections[pNode].put(cNode, distance);
                }

                cNode = Integer.parseInt(st.nextToken());
            }
        }

        isVisit[1] = true;
        dfs(1, 0);
        isVisit[1] = false;
        isVisit[endNode] = true;;
        dfs(endNode,0);

        System.out.println(maxDistance);

    }

    static void dfs(int pNode, int distance){
        if(distance > maxDistance){
                maxDistance = distance;
                endNode = pNode;
        };

        if(connections[pNode] != null){
            for(int key : connections[pNode].keySet()){
                if(!isVisit[key]){
                    isVisit[key] = true;
                    dfs(key, distance + connections[pNode].get(key));
                    isVisit[key] = false;
                }
            }
        }
    }
}
