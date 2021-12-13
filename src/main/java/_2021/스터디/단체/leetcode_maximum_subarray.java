package _2021.스터디.단체;

import java.util.Arrays;

public class leetcode_maximum_subarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    static int maxSubArray(int[] nums) {
        int max = 0;
        for(int i=1; i<nums.length; i++){
            nums[i] = Math.max(nums[i], nums[i]+nums[i-1]);
            if(max < nums[i]){
                max = nums[i];
            }
        }
        Arrays.sort(nums);
        return nums[nums.length-1];
    }
}