import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String X = st.nextToken();
        String Y = st.nextToken();
        System.out.println(getRev(String.valueOf(getRev(X)+getRev(Y))));
    }

    static int getRev(String numStr){
        char[] orginArr = numStr.toCharArray();
        char[] result = new char[orginArr.length];
        for(int i = 0 ; i < orginArr.length ; i++){
            result[i] = orginArr[orginArr.length-1-i];
        }
        return Integer.parseInt(new String(result));
    }
}