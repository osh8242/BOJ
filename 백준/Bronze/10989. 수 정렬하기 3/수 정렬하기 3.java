import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[10000];
		int n = Integer.parseInt(br.readLine());
		for (int i = 0 ; i < n ; i++) {
			arr[Integer.parseInt(br.readLine())-1]++;
		}
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i] ; j++) {
				bw.write(i+1+"\n");
			}
		}
		bw.flush();
		bw.close();		
	}
}