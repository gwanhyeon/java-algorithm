import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 영화감독숌 {

    public static void main(String[] args) throws IOException {
        String answer = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();

        StringBuilder s = new StringBuilder();
        s.append("666");

        // 출력 초과 ?
        for(int i=1; i<=10000; i++){
            String ans = "";
            if(i%6 == 0){
                s.append("6");
            }
            if((i - 1) % 6 != 0) {
                ans = Integer.toString((i - 1) % 6) + s;
            }else {
                ans = String.valueOf(s);
            }

            if(i == n){
                answer = ans;
                break;
            }

        }
        System.out.println(answer);
    }
}
