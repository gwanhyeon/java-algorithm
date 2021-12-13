package _2021.알고리즘유형별.DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수1003 {
    static int[] dp_zero = new int[41];
    static int[] dp_one = new int[41];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp_zero[0] = 1;
        dp_zero[1] = 0;

        dp_one[0] = 0;
        dp_one[1] = 1;
        while(n-- > 0){
            int value = Integer.parseInt(br.readLine());
            if(value == 0){
                dp_one[value] = 0;
                dp_zero[value] = 1;
            }
            else {
                for(int i=2; i<=value; i++){
                    dp_zero[i] = dp_zero[i-1] + dp_zero[i-2];
                    dp_one[i] = dp_one[i-1] + dp_one[i-2];

                }
            }
            System.out.println(dp_zero[value] + " " + dp_one[value]);

        }
    }
}
