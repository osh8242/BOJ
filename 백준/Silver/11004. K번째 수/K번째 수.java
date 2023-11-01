import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] array, temp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        array = new int[N];
        temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) array[i] = Integer.parseInt(st.nextToken());
        mergeSort(0, N - 1);
        System.out.println(array[K - 1]);
    }

    static void mergeSort(int start, int end) {
        if(start<end){
            int middle = (start+end)/2;
            mergeSort(start,middle);
            mergeSort(middle+1,end);

            int left = start;
            int right = middle+1;
            int index = left;
            while(left <= middle || right <= end){
                if(right > end || (left<=middle && array[left] < array[right])) temp[index++] = array[left++];
                else temp[index++] = array[right++];
            }
            for(int i = start ; i <= end ; i++) array[i] = temp[i];
        }
    }

}
