package 스터디.단체;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_MoveZeros_kgh {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
    static void moveZeroes(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                q.add(nums[i]);
            }
        }
        for(int i=0; i<nums.length-q.size()+1; i++){
            q.add(0);
        }

        while(!q.isEmpty()){
            System.out.print(q.poll());
        }

    }
}
