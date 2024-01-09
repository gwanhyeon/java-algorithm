package _2024.programmers_01;

import java.util.Arrays;

class 평균구하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{10, 20, 30}));

    }
    static class Solution{
         public  double solution(int[] arr) {
            double answer = 0;
            answer = Arrays.stream(arr).sum();
            return answer / arr.length;
        }
    }

}
