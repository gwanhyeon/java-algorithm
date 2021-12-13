package _2021.프로그래머스.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 규칙이 나오는문제
 * i % st.length
 * 5, 7 , 8의 규칙대로 순서를 나오는거 처리할때 이런식으로 처리하면 매우쉽다.
 *
 */
public class 모의고사 {
    public static void main(String[] args) {
        solution(new int[] {1,2,3,4,5});
    }
    static int[] solution(int[] answers) {

        int[] st1 = {1,2,3,4,5};
        int[] st2 = {2,1,2,3,2,4,2,5};
        int[] st3 = {3,3,1,1,2,2,4,4,5,5};
        int[] studentSum = new int[3];
        // 0 % 5 = 0, 1 % 5 = 1
        for(int i=0; i<answers.length; i++){
            if(st1[i % st1.length] == answers[i]){
                studentSum[0]++;
            }
            if(st2[i % st2.length] == answers[i]){
                studentSum[1]++;
            }
            if(st3[i % st3.length] == answers[i]){
                studentSum[2]++;
            }
        }

        int max = studentSum[0];
        List<Integer> arrList = new ArrayList<>();
        for(int i=0; i<studentSum.length; i++){
            if(max < studentSum[i]){
                max = studentSum[i];
            }
        }

        for(int i=0; i< studentSum.length; i++){
            if(max == studentSum[i]){
                arrList.add(i+1);
            }
        }
        int[] result = new int[arrList.size()];
        Collections.sort(arrList);

        for (int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println("i = " + result[i]);
        }
        return result;
    }
}
