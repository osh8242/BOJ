import java.io.*;
import java.util.*;

public class Main {
	
	static boolean[] isVisited;
	static boolean[][] isConnected;
	static int n;
	static StringBuilder sb;
	static Queue<Integer> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		isVisited = new boolean[n+1];
		isConnected = new boolean[n+1][n+1];
		for (int i = 0 ; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			isConnected[start][end] = true;
			isConnected[end][start] = true;
		}
		sb = new StringBuilder();
		dfs(v);
		System.out.println(sb.toString());
		sb = new StringBuilder();
		isVisited = new boolean[n+1];
		que = new LinkedList<>();
		bfs(v);
		System.out.println(sb.toString());
		
	}
	
	public static void dfs(int v) {
		isVisited[v] = true;
		sb.append(v+" ");
		for(int i = 1 ; i <= n ; i++) {
			if(isConnected[v][i] == true && isVisited[i] == false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		if(isVisited[v] == false) {
			isVisited[v] = true;
			sb.append(v+" ");
		}
		
		for (int i = 1 ; i <= n ; i++) {
			if(isConnected[v][i] == true && isVisited[i] == false) {				
				que.add(i);
			}			
		}
		if(!que.isEmpty()) {
			bfs(que.poll());
		}
	}
		
}
