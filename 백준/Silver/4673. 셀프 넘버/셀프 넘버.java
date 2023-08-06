class Main {
    public static void main(String[] args){
        boolean[] isDnumber = new boolean[10001];
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= 10000 ; i++){
            isDnumber[getDnumber(i)] = true;
        }
        for(int i = 1 ; i <= 10000; i++){
            if(!isDnumber[i]) sb.append(i+"\n");
        }
        System.out.println(sb);
    }

    static int getDnumber(int num){
        String str = String.valueOf(num);
        int answer = num;
        for(int i = 0 ; i < str.length() ; i++){
            answer += Character.getNumericValue(str.charAt(i));
            if(answer > 10000) return 0;
        }
        return answer;
    }

}
