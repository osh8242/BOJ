import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int count = 1;
		int overNum = -1;
		TreeSet<Integer> set = new TreeSet<>();		
		set.add(a);
		if(!set.add(b)) {
			count++;
			overNum=b;
		}
		if(!set.add(c)) {
			count++;
			overNum=c;
		}
		switch(count) {
			case 3:{
				System.out.println(10000+overNum*1000);	break;	
			}
			case 2:{
				System.out.println(1000+overNum*100); break;
			}
			case 1:{
				System.out.println(set.last()*100);
			}
		}
	}

}
