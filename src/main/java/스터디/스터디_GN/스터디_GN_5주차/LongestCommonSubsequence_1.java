package 스터디.스터디_GN_5주차;

/**
 * Longest Common Sequence 공통부분문자열의 길이를 구하는 경우
 * https://fbtmdwhd33.tistory.com/58
 * https://www.youtube.com/watch?v=P-mMvhfJhu8&feature=youtu.be
 */

public class LongestCommonSubsequence_1 {

    public static void main(String[] args) {

        String a = "BDCABA";
        String b = "ABCBDAB";

        //공집합표현을 위해 +1 한줄 추가
        int[][] dp = new int[b.length()+1][a.length()+1];

        for(int i=1; i<=b.length(); i++){
            for(int j=1; j<=a.length(); j++){
                // 두 문자를 비교하였을때 값이 같지 않을 경우
                if(b.charAt(i-1) != a.charAt(j-1)){
                    // left, top 값중에 더 큰값을 기준으로 값 세팅
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }else {
                    dp[i][j] = dp[i-1][j-1]+1;        // 다리를 잇는경우 대각선의 값 + 1
                }
            }
        }
        System.out.println(dp[b.length()][a.length()]);

    }
}
