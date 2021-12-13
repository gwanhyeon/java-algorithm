package _2021.알고리즘유형별.Math;

import java.util.ArrayList;



/* 구간합 구하기 O(N)



 */
public class 구간합구하기 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {10,20,30,40,50};
        int summary = 0;
        ArrayList<Integer> prefix_sum = new ArrayList<>();

        for(int i : arr){
            summary += i;
            prefix_sum.add(summary);
        }

        for(int i : prefix_sum){
            System.out.println(i);
        }

        int left = 3;
        int right = 4;

        // 부분합을 구한후에 가장큰 값 - 가장작은값 범위의 값을 뽑는것이 결국엔 구간의 합을 나타내는것과 같은 으미ㅣ이다.

        System.out.println("정답:" + (prefix_sum.get(right) - prefix_sum.get(left-1)));

    }
}
