package _2021.알고리즘유형별.Sort;

import java.util.Collections;
import java.util.PriorityQueue;

/* 유사문제 aa.프로그래머스 배달 PriorityQueue Collections.reverseOrder()를 하게 되면 가장 큰 값으로부터 우선순위를 정해서 진행한다.  */


public class 프로그래머스_프린터 {
    public static void main(String[] args) {
        //System.out.println(solution(new int[]{2,1,3,2}, 2));
        System.out.println(solution(new int[]{1,1,9,1,1}, 0));
    }
    static int solution(int[] priorities, int location) {
        int answer = 0;
        /*
        ps. Priority Queue는 그냥 만들면 최소값 기준으로 우선순위 된다. new Priority Queue(Collections.reverseOrder())로 생성해주게 되면 최대값 기준으로 우선순위가 정렬된다.
         */
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());         //Collections.reverseOrder() 최댓값 기준으로 정렬
        for(int value : priorities){
            q.offer(value);
        }
        boolean tf = false;
        while(!q.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == q.peek()){
                    System.out.println(q.peek());
                    q.poll();
                    answer++;
                    if(location == i){
                        tf = true;
                        break;
                    }
                }
            }
            if(tf){
                break;
            }
        }
        return answer;

    }
}
