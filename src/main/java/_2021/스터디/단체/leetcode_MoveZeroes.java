package _2021.스터디.단체;

public class leetcode_MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
    static void moveZeroes(int[] nums) {

        int count = 0;

        // 0 0 1 3 12
        //Arrays.sort(nums);
        int curr = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[curr];
                nums[curr] = tmp;
                curr++;
            }
        }
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }
}
