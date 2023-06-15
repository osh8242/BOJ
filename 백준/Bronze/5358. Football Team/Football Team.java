import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp = "";
        while((temp = br.readLine()) != null){
            int length = temp.length();
            char[] charArr = temp.toCharArray();
            for(int i = 0 ; i < length ; i++){
                switch (charArr[i]){
                    case 'e' : charArr[i] = 'i'; break;
                    case 'i' : charArr[i] = 'e'; break;
                    case 'E' : charArr[i] = 'I'; break;
                    case 'I' : charArr[i] = 'E'; break;
                }
            }
            sb.append(new String(charArr)+"\n");
        }
        System.out.println(sb);

    }

}
