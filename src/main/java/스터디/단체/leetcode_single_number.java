package 스터디.단체;




import java.util.HashMap;
import java.util.Map;
public class leetcode_single_number {

    public static void main(String[] args) {
        singleNumber(new int[]{2,2,1});
        singleNumber(new int[]{4,1,2,1,2});
    }
    static int singleNumber(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int answer = 0;
        for(int i=0; i<nums.length; i++) {
            m.merge(nums[i], 1, Integer::sum);
        }
        for(Integer key : m.keySet()){
            Integer value = m.get(key);
            if(value == 1){
                answer = key;
                System.out.println(key);
                break;
            }
        }
        return answer;
    }
}
