import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> deck = new LinkedList<>();
		for (int i = 0 ; i < n ; i++) {
			String line = br.readLine();			
			switch(line.charAt(0)) {
				case 'p':{
					switch(line.charAt(1)) {
						case'u':{
							switch(line.charAt(5)){
								case'f':{
									deck.offerFirst(Integer.parseInt(line.substring(line.indexOf(" ")+1)));
									break;
								}
								case'b':{
									deck.offerLast(Integer.parseInt(line.substring(line.indexOf(" ")+1)));
									break;	
								}
							}
							
						}
						case'o':{
							switch(line.charAt(4)){
								case'f':{
									if(!deck.isEmpty()) {
										sb.append(deck.pollFirst()+"\n");
									} else {
										sb.append(-1+"\n");
									}
									break;
								}
								case'b':{
									if(!deck.isEmpty()) {
										sb.append(deck.pollLast()+"\n");
									} else {
										sb.append(-1+"\n");
									}
									break;
								}
							}
						}
							
					}
					break;
				}
				
				case 's':{
					sb.append(deck.size()+"\n");
					break;
				}
				case 'e':{
					if(deck.isEmpty()) {
						sb.append(1+"\n");
					} else {
						sb.append(0+"\n");
					}
					break;
				}
				case 'f':{
					if(!deck.isEmpty()) {
						sb.append(deck.getFirst()+"\n");
					} else {
						sb.append(-1+"\n");
					}
					break;
				}
				case 'b':{
					if(!deck.isEmpty()) {
						sb.append(deck.getLast()+"\n");
					} else {
						sb.append(-1+"\n");
					}
					break;				
				}
			}//main switch
		
		}//for
		System.out.println(sb.toString());
	}//main

}//class
