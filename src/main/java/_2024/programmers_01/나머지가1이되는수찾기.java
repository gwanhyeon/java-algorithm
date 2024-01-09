package _2024.programmers_01;



public class 나머지가1이되는수찾기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10));
    }
    static class Solution {
        public int solution(int n) {
            int answer = Integer. MAX_VALUE;

            for(int x=1; x<=n; x++){
                if(n % x == 1){
                    answer = Math.min(x,answer);
                }
            }

            return answer;
        }
    }
}
