package _2021.스터디.스터디_GN.스터디_GN_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 포도주 시식, 계단오르기 문제와 같다.
 * https://chanhuiseok.github.io/posts/algo-49/
 * https://developer-mac.tistory.com/71
 *
 * 항상 뒤에값이 커야한다 앞에값보다 !!! 중요함(전투력문제 항상 뒤쪽에 있는 병사보다 높아야한다) 라는 조건이 있다.
 * 가장 긴것의 개수를 찾는 문제
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] cost = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // i번째 인덱스에서 끝나는 최장 증가 부분 수열의 길이
        for(int i=0; i<n; i++){
            cost[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            // j < i 범위를 만족하고 cost[i] > cost[j]에 범위까지 진행할 수 있어야합니다.
            // j < i 범위를 만족하고 있기때문에 최장증가부분수열의 길이가 더 크다면 +1을 통해서 그 마지막끝 값을 추가하는 의미로 생각해야하고
            // i값이 점점커지면서 범위를 만족하는범위를 좁혀들어오기때문에 중요합니다
            for(int j=0; j<i; j++){
                if(cost[i] > cost[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // 최댓값을 갱신해서 나간다.
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}