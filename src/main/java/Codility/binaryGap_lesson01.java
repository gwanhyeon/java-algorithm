package Codility;

import java.util.ArrayList;
import java.util.List;

/**
 * BinaryGap
 1. N의 값 이진수로 변환합니다.
 2. 이진수로 변환후 1의 위치를 리스트에 저장합니다.
 3. 리스트에 담긴 위치별로 substring을 사용하여 값에 대한 length를 체크하여 최댓값을 구해줍니다.
 시간복잡도: O(N)
 */
public class binaryGap_lesson01 {
    public static void main(String[] args) {
        solution(9);
        solution(1162);
    }
    static int solution(int N) {
        // write your code in Java SE 8
        /*
        List<Integer> arrList = new ArrayList<>();
        while(N > 0){
            int div = N % 2;
            N = N / 2;
            arrList.add(div);
        }
        Collections.reverse(arrList);
         */
        String binaryStr = Integer.toBinaryString(N);

        int cnt = 0;
        List<Integer> arrList = new ArrayList<>();
        for(int i=0; i<binaryStr.length(); i++){
            if(binaryStr.charAt(i) == '1'){
                cnt++;
                arrList.add(i);
            }
        }
        int answer = 0;
        if(cnt > 0) {
            for (int i = 0; i < arrList.size() - 1; i++) {
                String subStr = binaryStr.substring(arrList.get(i), arrList.get(i+1));
                answer = Math.max(answer, subStr.length()-1);
            }
        }
        //System.out.println("answer = " + answer);
        return answer;
    }
}
