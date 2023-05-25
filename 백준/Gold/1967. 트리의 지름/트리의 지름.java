import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<Integer,Integer>[] connections;
    static int endNode = -1;
    static int maxDistance = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        connections = new HashMap[n+1];
        for(int i = 1 ; i < n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pNode = Integer.parseInt(st.nextToken());
            int cNode = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if(connections[pNode] == null) connections[pNode] = new HashMap<>();
            if(connections[cNode] == null) connections[cNode] = new HashMap<>();
            connections[pNode].put(cNode,distance);
            connections[cNode].put(pNode,distance);
        }
        dfs(1,0);
        dfs(endNode, 0);
        System.out.println(maxDistance);

    }

    static void dfs(int p, int totalDistance){
        if(totalDistance > maxDistance) {
            maxDistance = totalDistance;
            endNode = p;
        }
        if(connections[p] != null){
            for(int key : connections[p].keySet()){
                connections[key].remove(p);
                dfs(key, totalDistance + connections[p].get(key));
                connections[key].put(p,connections[p].get(key));
            }
        }
    }

}
