package _2021.스터디.스터디_GN.스터디_GN_14_주차;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값만들기_kgh {
    public static void main(String[] args) {
        solution(new int[]{1,4,2}, new int[]{5,4,4});
    }
    static int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Integer[] BB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(BB, Collections.reverseOrder());
        int answer = 0;
        // 1 2 4, 4 4 5
        // 4 8 20
        for(int i=0; i<A.length; i++){
            answer += (A[i] * BB[i]);
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
