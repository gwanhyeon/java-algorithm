package _2023.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1463 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[1] = 0;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+1;
            if(i%2 == 0 && dp[i] > dp[i/2] + 1){
                dp[i] = dp[i/2] + 1;
            }
            if(i%3 == 0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i/3] + 1;
            }

        }
        System.out.println(dp[n]);

    }
}
