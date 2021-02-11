package 알고리즘유형별.Oncoder;

public class 피보나치수 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10));

    }
    //핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
    public static class Solution{
        public long solution(int n){
            long answer=0;

            if(n == 0){
                answer = 0;
                return answer;
            }
            long[] dp = new long[n+1];
            dp[0] = 1;
            dp[1] = 1;


            for(int i=2; i<n; i++){
                dp[i] = dp[i-2] + dp[i-1];
            }
            answer = dp[n-1];
            return answer;
        }
    }
}
