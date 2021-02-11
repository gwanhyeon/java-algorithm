package 스터디.스터디_GN.스터디_GN_1주차;

import java.util.Arrays;

/**
 * 1. 풀이시간:40분
 * comment 그리디알고리즘 접근방법을 제대로 확인하지 못하였음.
 * 2. O(N^2) 로 접근하였다가 재귀로 접근하였는데 접근방식을 떠올릴수없었다. 최적의 해를 구해야한다라는것을 체킹하여야한다.
 * 오름차순 정렬후 타겟에 동전을 더해나가면서 타겟값보다 동전값이 커지는경우 즉 금액을 더 만들기가 불가능할 경우에 종료시켜 정답을 출력한다.
 *
 * 만들수 없는 금액을 풀기위해서는 정렬후 -> 값이 작은값부터 시작해서 sum의 값을 1로 세팅해야 한다.
 * 테스트케이스를 보면 357의 경우에는 가장 만들수없는 가장 최소의 값이 1으로 나오는것을 알 수 있다.
 *
 * 3. O(N^2)
 */
public class 만들수없는금액_그리디 {
    static int[] check;
    public static void main(String[] args) {
        solution(5, new int[]{3,2,1,1,9});
        solution(3, new int[]{3,5,7});
        //solution(3, new int[]{500,100,50});
    }

    private static void solution(int n, int[] coins) {
        Arrays.sort(coins); // 11239
        int sum = 1;
        for(int i=0; i<coins.length; i++){
            if(sum < coins[i]){
                break;
            }
            sum += coins[i];
        }
        System.out.println(sum);
    }
}
