package _2021.스터디.단체;

public class leetcode_Climbing_Stairs_kgh {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
    static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];

    }
}
