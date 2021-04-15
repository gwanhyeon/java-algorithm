import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연속합1912DP {
    static int[] dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int max = dp[0];

        for(int i=1; i<n; i++){
            if(dp[i] + dp[i-1] > 0 && dp[i-1] > 0){
                dp[i] = dp[i-1] + dp[i];
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }
         /*
        첫번째 경우 dp[i-1] > 0
          이전의 합이 음수라면 선택하지 않습니다.
        두번째 경우 dp[i] + dp[i-1] > 0
          이전의 합과 현재의 수를 더한 값이 음수라면 선택하지 않습니다.
         */
        System.out.println(max);

    }
}
