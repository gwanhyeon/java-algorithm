package _2021.프로그래머스.Level1;

import java.util.*;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        solution(new int[]{2,1,3,4,1});
    }
    static int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> s = new HashSet<>();
        Arrays.sort(numbers);
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                s.add(numbers[i] + numbers[j]);
            }
        }
        return s.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
