package _2024.programmers_highscore;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        int answer = 0;
        Set<Integer> s = new HashSet<>();

        for(int num : nums){
            s.add(num);
        }
        answer = Math.min(s.size(), nums.length/2);
        System.out.println(answer);
    }

}
