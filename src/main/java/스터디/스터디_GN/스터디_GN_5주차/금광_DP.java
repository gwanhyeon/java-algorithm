package 스터디.스터디_GN.스터디_GN_5주차;

import java.util.Scanner;

public class 금광_DP {
    static int T, n, m;
    static int[][] arr = new int[20][20];
    static int[][] dp = new int[20][20];


    /*
    1
    3 4
    1 3 3 2
    2 1 4 1
    0 6 4 7
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스(Test Case) 입력
        T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            // 금광 정보 입력
            n = sc.nextInt();
            m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    dp[i][j] = arr[i][j];
//                }
//            }
            for(int i=0; i<n; i++){
                dp[i][0] = arr[i][0];
            }
            // 1부터 시작하는이유는 시작점이 해당 열에서부터 시작하기 때문에 1부터 진행
            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    // 맨위에 위치해있을 경우 -> 왼쪽위에 지점을 0으로 진행
                    if(i == 0){
                        dp[i][j] = arr[i][j] + Math.max(0, Math.max(dp[i+1][j-1], dp[i][j-1]));
                    }
                    // 맨아래에 위치해있을 경우 -> 왼쪽아래 지점을 0 으로 진행
                    else if(i == n-1){
                        dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], Math.max(0, dp[i][j-1]));
                    }
                    // 중간에 위치해있을경우 올바르게 값 처리
                    else {
                        dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i+1][j-1], dp[i][j-1]));
                    }
                }
            }
            int result = 0;
            // i, m-1지점에 각 지점에 대한 최댓값이 들어가있기때문에 해당값중에서 가장 큰 값을 뽑아내준다.
            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i][m - 1]);
            }
            System.out.println(result);
        }
    }
}
