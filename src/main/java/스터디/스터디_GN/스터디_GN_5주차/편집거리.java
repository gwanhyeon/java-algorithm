package 스터디.스터디_GN.스터디_GN_5주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Minimum Edit Distance 알고리즘
 * 1. 현재 비교할값의 기준으로
 * 0~a, 0~b 까지의 값을 길이만큼 인덱스값을 초기화시켜줍니다(0~length)
 * 2. 각각의 문자를 비교합니다.
 * (1) 비교하려는 값이 두값이 모두 동일할 경우
 * 현재값의 기준으로 대각선에 있는값으로 메모이제이션을 시킵니다.
 * (2) 비교하려는 값이 다를 경우
 * 현재값의 기준으로 대각, 위, 아래의 최솟값을 구해서 +1을 시켜줍니다. 이전의 값에서 해당값들을 구해줬으므로 최소(즉 공통이 되는값에서) 하나의 값을 추가해주는의미와 같습니다.
 */
public class 편집거리 {

    public static void main(String[] args) throws IOException {
        int[][] dp = new int[5001][5001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        dp[0][0] = 0;
        for(int i=0; i<a.length(); i++){
            dp[i][0] = i;
        }
        for(int i=0; i<b.length(); i++){
            dp[0][i] = i;
        }
        for(int i=1; i<a.length(); i++){
            for(int j=1; j<b.length(); j++){
                // 둘다 값이 같을 경우
                if(a.charAt(i) == b.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        System.out.println(dp[a.length()-1][b.length()-1]);
    }
}
