package _2021.스터디.스터디_SNU.Section01;

// comment: 1주차 알고리즘 leetcode 1.Two Sum 문제
// comment: https://leetcode.com/problems/two-sum/


import java.util.HashMap;

/*
풀이시간: 10분
컴퓨팅사고:
단순히 2중포문을 돌면서 twoSum을 풀면됩니다.

 */
public class leetcode_TwoSum_kgh {
    public static void main(String[] args) {
        solution(new int[]{2, 7, 11, 15}, 9);
        solution(new int[]{2, 7, 11, 15}, 9);
    }

    static void solution(int[] nums, int target) {
        int[] answer = {0, 0};
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        System.out.println(answer[0] + "" + answer[1]);
    }
    static void solution1(int[] nums, int target) {
        // <value, idx>
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] answer = new int[2];
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                int leftIdx = hm.get(nums[i]);
                answer[0] = leftIdx;        // left idx
                answer[1] = i;              // right idx
                return;
            }else {
                hm.put(target-nums[i], i);
            }
        }
    }
}
