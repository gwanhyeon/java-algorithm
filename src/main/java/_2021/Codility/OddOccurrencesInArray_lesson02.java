package _2021.Codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. map을 사용하여 짝을 이루는지 안이루는지 value를 설정합니다.
 * 만약 동일한 값이 존재하면 value+1, 그게 아니면 1
 * 2. map에 존재하는 value중에서 홀수인 값의 key값을 리턴해주면 정답이 됩니다.
 * 저 같은 경우 홀수값이 아닌 반드시 1의 값일 경우로 조건을 걸었다가 68%에서 터져서 다시 살펴보니 문제를 잘못읽어 홀수에 대한 처리를 정확하게 하지 못했습니다.
 */
public class OddOccurrencesInArray_lesson02 {
    public static void main(String[] args) {
        solution(new int[]{2, 2, 3, 3, 4});
        solution(new int[]{9,3,9,3,9,7,9});
        solution(new int[]{42});
    }
    static int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> m = new HashMap<>();
        Arrays.sort(A);
        for(int i=0; i<A.length; i++){
            if(!m.containsKey(A[i])){
                m.put(A[i], 1);
            }else {
                int mValue = m.get(A[i]);
                m.put(A[i], mValue+1);
            }
        }
        int answer = 0;
        for(Integer key :  m.keySet()){
            int value = m.get(key);
            if(value % 2 != 0){
                answer = key;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
