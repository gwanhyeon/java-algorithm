package 스터디.스터디_GN.스터디_GN_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준LCS_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                // 문자가 같을 경우
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}
