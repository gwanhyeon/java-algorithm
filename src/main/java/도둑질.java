public class 도둑질 {
    static int[][] dp;
    public static void main(String[] args) {

        int[] money = {1,2,3,1};
        int[] dp = new int[money.length];
        int[] dp1 = new int[money.length];

        //첫번째 집을 훔치는 경우
        dp[0] = money[0]; // 첫번째집의 돈 훔치기
        dp[1] = money[0]; // 첫번째집을 훔치는경우는 두번째집을 선택할수없기때문에 두번째집도 지금까지 가장 큰 첫번째집 돈을 넣어준다.

        //첫번째 집을 훔치지 않는 경우
        dp1[0] = 0;     //첫번째집 훔치지않으므로 0
        dp1[1] = money[1]; //두번째집은 훔치는 가격

        for(int i=2; i<money.length-1; i++){
            dp[i] = Math.max(dp[i-2] + money[i], dp[i-1]);      // 1번째 세번째 훔치는 경우
        }

        for(int i=2; i<money.length; i++){
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
        }
        System.out.println(Math.max(dp[money.length-2], dp1[money.length-1]));
    }
}
