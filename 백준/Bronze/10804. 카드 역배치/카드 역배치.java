import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cards = new int[21];
        for(int i = 1 ; i <= 20 ; i++) cards[i] = i;
        for(int i = 1 ; i <= 10 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arrangeCards(start, end);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= 20 ; i++){
            sb.append(cards[i]).append(" ");
        }
        System.out.println(sb);

    }

    static void arrangeCards(int start, int end){
        int length = end-start+1;
        if(length == 1) return;
        int[] temp = new int[length+1];
        for(int i = 1 ; i <= length ; i++){
            temp[i] = cards[end-i+1];
        }
        for(int i = start ; i <= end ; i++){
            cards[i] = temp[i-start+1];
        }

    }

}
