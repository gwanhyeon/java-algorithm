package _2021.스터디.스터디_GN.스터디_GN_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 컴퓨팅 사고 :
 *
 * 뒤에서 부터 dp를 통하여 가장 큰 경우의 수부터 구해주게 된다.
 * currTime이 n범위를 만족하면
 * 현재 가격 + dp에 저장되어온 현재 가격을 더해준 값을 max값과 비교하여 dp[i]에 넣어주게 된다.
 */
public class 백준_퇴사_DP {
    public static void main(String[] args) throws IOException {
        int[] time = new int[15];
        int[] price = new int[15];
        int[] dp = new int[16];

        int max = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=n-1; i>=0; i--){
            int currTime = time[i] + i;
            if(currTime <= n){
                dp[i] = Math.max(price[i]+dp[currTime], max);
                max = dp[i];
            }else {
                dp[i] = max;
            }
        }
        System.out.println(max);
    }
}
