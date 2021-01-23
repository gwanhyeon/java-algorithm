package 스터디.스터디_GN_5주차;

/**
 * Longest Common Subsequence
 */
public class LongestCommonSubsequence_2 {
    public static void main(String[] args) {

        String aa = "BDCABA";
        String bb = "ABCBDAB";
        char[] a = aa.toCharArray();
        char[] b = bb.toCharArray();


        int[][] dp = new int[a.length+1][b.length+1];

        for(int i=1; i<=a.length; i++){
            for(int j=1; j<=b.length; j++){

                // 두문자를 비교하여서 같다면 대각선 전의 경우의 수에 해당 문자가 추가되는 경우이므로 +1
                if(a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;          //대각선의 값 + 1
                }
                // 두 문자가 같지 않다면
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);            // left top 값비교해서 더 큰값을 넣어준다.
                }
            }
        }
        System.out.println(dp[a.length][b.length]);
    }
}
