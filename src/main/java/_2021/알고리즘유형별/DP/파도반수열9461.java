package _2021.알고리즘유형별.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열9461 {
    static long[] dp = new long[101];
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());


        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            for(int i=3; i<n; i++){
                dp[i] = dp[i-3] + dp[i-2];
            }
            System.out.println(dp[n-1]);
        }
    }
}
