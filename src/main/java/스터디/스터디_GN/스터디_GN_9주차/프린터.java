package 스터디.스터디_GN.스터디_GN_9주차;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프린터 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
    }
    static int solution(int[] priorities, int location) {
        // 큰 것부터 비교해주어야하므로 reverseOrder() 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            pq.add(priorities[i]);
        }
        int answer = 0;
        // 3 2 2 1
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(pq.peek() == priorities[i]){
                    pq.poll();
                    answer++;
                    if(location == i){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}