package _2021.스터디.스터디_GN.스터디_GN_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 왼쪽과 오른쪽 경우의 DP를 나누어서 생각한다.
 * 구해주려고하는값을 기준으로 = 더하려고하는값 + (더해져온값중 큰값을) 찾아주게된다.
 */
public class 정수삼각형 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        5
        7
        3 8
        8 1 0
        2 7 4 4
        4 5 2 6 5
         */

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while(st.hasMoreTokens()){
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        int answer = 0;
        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                // left
                dp[i][j-1] = Math.max(dp[i-1][j-1] + arr[i][j-1], dp[i][j-1]);
                answer = Math.max(dp[i][j-1], answer);
                // right
                dp[i][j] = Math.max(dp[i-1][j-1] + arr[i][j], dp[i][j]);
                answer = Math.max(dp[i][j], answer);
            }
        }
        System.out.println(answer);

    }
}
