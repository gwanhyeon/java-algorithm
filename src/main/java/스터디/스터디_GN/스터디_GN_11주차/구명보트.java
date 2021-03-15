package 스터디.스터디_GN.스터디_GN_11주차;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42885
public class 구명보트 {
    public static void main(String[] args) {
        solution(new int[]{70,50,80,50}, 100);
//        solution(new int[]{70,80,50},100);
    }
    static int solution(int[] people, int limit) {
        int answer = people.length;
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        while(start < end){
            // 둘이 보트를 같이 탄 경우라면 현재 인원에서 -1을 진행한다.
            // 몸무게가 가장 많은 사람을 기준으로 비교하는것이 좋은방법이다.
            if(people[start] + people[end] <= limit) {
                start++;
                answer--;
            }
            end--;
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
