package _2021.프로그래머스.Level1;

import java.util.*;

/**
 * 정렬을 진행하면안된다.
 * 가장작은값이 여러개가 올 수 있다.
 * 풀이시간:30분
 *
 * 미친이런문제를 존나늦게풀었네.
 */
public class 제일작은수제거하기 {
    public static void main(String[] args) {
//        solution(new int[]{4,3,2,1});
        solution(new int[]{1,2,5,2});
    }
    public static int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        if(arr.length == 1){
            return new int[]{-1};
        }
        List<Integer> arrList = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            arrList.add(arr[i]);
        }
        int min = arrList.get(0);

        for(int i=0; i<arrList.size(); i++){
            min = Math.min(min,arrList.get(i));
        }
        int idx = 0;
        for(int i=0; i<arrList.size(); i++){
            if(min == arrList.get(i)){
                continue;
            }
            answer[idx++] = arrList.get(i);
        }
        return answer;
    }
}
