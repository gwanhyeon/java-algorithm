package 스터디.스터디_GN.스터디_GN_5주차;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 풀이시간: 3분
 * 2. 컴퓨팅사고
 * 2 또는 3 또는 5를 나눈 나머지가 0이면 못생긴수입니다.(단, 1도 못생긴수라고 가정합니다)
 * 리스트에 해당 못생긴수들을 넣어주고, 찾고자하는 n-1번째 값을 출력시켜줍니다.
 */
public class 못생긴수 {
    public static void main(String[] args) {
        soultion1(4);
        solution2(4);

    }

    private static void solution2(int n) {
        int[] dp = new int[1001];
        int num1Idx = 0,num2Idx = 0,num3Idx = 0;
        int num1 = 2,num2 = 3,num3 = 5;

        dp[0] = 1;

        // 1
        // 1 * 2, 1 * 3, 1 * 5
        // 2 3 5
        // 2*2 3*3 5*3

        for(int i=1; i<n; i++){
            dp[i] = Math.min(num1, Math.min(num2,num3));
            if(dp[i] == num1){
                num1Idx++;
                num1 = dp[num1Idx] * 2;
            }
            if(dp[i] == num2){
                num2Idx++;
                num2 = dp[num2Idx] * 3;
            }
            if(dp[i] == num3){
                num3Idx++;
                num3 = dp[i] * 5;
            }
        }
        System.out.println(dp[n-1]);
    }

    static void soultion1(int n){
        List<Integer> primeFactor = new ArrayList<>();
        primeFactor.add(1);
        for(int i=2; i<=1000; i++){
            if(i % 2 == 0 || i % 3 == 0 || i % 5 == 0){
                primeFactor.add(i);
            }
        }
        System.out.println(primeFactor.get(n-1));
    }
}
