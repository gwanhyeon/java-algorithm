package _2021.스터디.스터디_GN.스터디_GN_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LIS 유사 문제
 */
public class 백준_포도주_2156_LIS {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] graph = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++){
            graph[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = graph[1];        // 한잔
        dp[2] = graph[1] + graph[2]; // 두잔
        /*
        1. 앞의 두잔을 마셔서 현재 잔을 못마시는 경우 ( O O X )
        2. 바로 앞의 잔만 마시고 현재 잔도 마시는 경우 ( X O O )
        3. 앞앞의 잔만 마시고 현재 잔도 마시는 경우 ( O X O )
         */
        for(int i=3; i<=n; i++){
            /*
            //경우의 수
			1. 앞의 두잔을 마신상태여서 안먹을 경우
			2. 바로 앞(i-1)꺼만 마신상태에서 지금의 잔도 먹을 경우(+ 4번째 잔부터라면 i-3일때 가장많이 마실 수 있는 양도 더해줌)
			3. i-2꺼만 마시고 i-1는 안마신상태에서 먹을 경우
             */
            dp[i] = Math.max(dp[i-1], Math.max(graph[i-1]+graph[i]+dp[i-3], dp[i-2]+graph[i]));
            // 3 = 2 , 2+3+0, dp[1]+[3]
        }
        System.out.println(dp[n]);
    }
}
