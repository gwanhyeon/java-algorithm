package _2021.알고리즘유형별.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB거리1149 {
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        dp = new int[n+1][3];
        arr = new int[n+1][3];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 유형별.DP RGB 0 초기화
        // ARR RGB 0 초기화
        dp[0][0] = dp[0][1] = dp[0][2] = arr[0][0] = arr[0][1] = arr[0][2] = 0;


        // R선택시 dp i-1는 R을 선택할 수 없으며, 다른 G,B값중 최솟값을 더해준다. 그리고 현재 R값을 추가해준다.
        // G선택시 dp i-1는 G를 선택할 수 없으며, 다른 R,B값중 최솟값을 더해준다. 그리고 현재 G값을 추가해준다.
        // B선택시 dp i-1는 B를 선택할 수 없으며, 다른 R,G값중 최솟값을 더해준다. 그리고 현재 B값을 추가해준다.

        for(int i=1; i<=n; i++){

            // R
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];

            // G
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];

            // B
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];

        }
        // 가장 최솟값을 구해주기

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));

    }
}
