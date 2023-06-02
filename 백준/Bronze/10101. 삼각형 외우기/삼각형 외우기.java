import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int sum = a+b+c;
        String str;
        switch (sum){
            case 180 :{
                if(a==b && b==c) str = "Equilateral";
                else if(a==b || b==c || c==a) str = "Isosceles";
                else str = "Scalene";
            } break;
            default :{
                str = "Error";
            }
        }
        System.out.println(str);

    }

}
