package 스터디.단체;

import java.util.ArrayList;
import java.util.List;

public class leetcode_Remove_Element {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3},3));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }
    static int removeElement(int[] nums, int val) {

        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        System.out.println(cnt);
        //arr.forEach(v -> System.out.print(v));

        return cnt;
    }
}
