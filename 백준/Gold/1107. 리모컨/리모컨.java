import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] isBroken = new boolean[10];
    static int[] channel, testInput;
    static int distance = Integer.MAX_VALUE;
    static int channelValue, btnValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine();
        channel = new int[numStr.length()];
        btnValue = -1;
        testInput = new int[numStr.length()+1];

        for(int i = 0 ; i < numStr.length() ; i++){
            channel[i] = numStr.charAt(i)-48;
        }
        channelValue = getValue(channel);

        int brokenCount = Integer.parseInt(br.readLine());
        if(brokenCount == 10) {
            System.out.println(Math.abs(channelValue-100));
            return;
        }
        if(brokenCount != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < brokenCount; i++) {
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int minWokringNum = -1;
        for(int i = 0 ; i < isBroken.length ; i++){
            if(!isBroken[i]) {
                minWokringNum = i;
                for(int j = 0 ; j < testInput.length ; j++){
                    testInput[j] = i;
                }
            }
        }


        for(int index = 0 ; index < testInput.length ; index++){
            for(int i = 0 ; i < 10 ; i++){
                if(!isBroken[i] || (i==0 && isFirstDigit(index))) completeSearch(index,i);
            }
        }
        if(Math.abs(channelValue-100) >= distance){
            System.out.println(distance);
        } else {
            System.out.println(Math.abs(channelValue-100));
        }


    } // main(){}

    static void completeSearch(int index, int num){
        testInput[index] = num;
        int testValue = getValue(testInput);
        if(testValue == 0 && isBroken[0]) return;
        int testValueLength = Integer.toString(testValue).length();

        if(distance > Math.abs(testValue-channelValue) + testValueLength) {
            distance = Math.abs(testValue-channelValue) + testValueLength;
            btnValue = testValue;
        }
        for(int i = index+1 ; i < testInput.length ; i++){
            for(int j = 0 ; j < 10; j++){
                if((!isBroken[j] || (j==0 && isFirstDigit(i)))) completeSearch(i,j);
            }
        }
    }

    static int getValue(int[] arr){
        int answer = 0;
        for(int index = 0 ; index < arr.length ; index++){
            int digit = arr[arr.length-1-index];
            for(int exp = 0 ; exp < index ; exp++){
                digit *= 10;
            }
            answer += digit;
        }
        return answer;
    }

    static boolean isFirstDigit(int index){
        for(int i = 0 ; i < index ; i++){
            if(testInput[i] != 0) return false;
        }
        return true;
    }

} // class Main{}
