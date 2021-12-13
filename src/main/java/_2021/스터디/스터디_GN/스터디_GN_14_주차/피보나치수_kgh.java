package _2021.스터디.스터디_GN.스터디_GN_14_주차;

public class 피보나치수_kgh {
    public static void main(String[] args) {
        solution(3);
    }
    static int solution(int n) {
        int answer = 0;
        int[] dp = new int[100001];
        // 0 + 1 = 1
        // 1 + 1 = 2
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        System.out.println(dp[n]);
        return answer;
    }
}
