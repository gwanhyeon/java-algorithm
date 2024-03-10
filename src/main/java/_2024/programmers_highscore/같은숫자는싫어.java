package _2024.programmers_highscore;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{2,3,4});

    }
    public static class Solution {
        public List<Integer> solution(int []arr) {

            List<Integer> answer = new ArrayList<>();
            answer.add(arr[0]);
            for(int i=1; i <arr.length; i++){
                if(arr[i-1] != arr[i]){
                    answer.add(arr[i]);
                }
            }
            return answer;
        }
    }
}
