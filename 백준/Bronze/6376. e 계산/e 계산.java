public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("n e").append("\n");
        sb.append("- -----------").append("\n");
        sb.append("0 1").append("\n");
        sb.append("1 2").append("\n");
        sb.append("2 2.5");
        System.out.println(sb);
        for(int i = 3 ; i < 10 ; i++){
            System.out.printf("%d %.9f\n",i,getEvalue(i));
        }
    }

    static double getEvalue(int n){
        double answer = 1;
        for(int i = 1 ; i <= n ; i++){
         answer += 1.0/getFactorial(i);
        }
        return answer;
    }

    static int getFactorial(int n){
        int answer = 1;
        for(int i = 1; i <= n ; i++) answer *= i;
        return answer;
    }
}
