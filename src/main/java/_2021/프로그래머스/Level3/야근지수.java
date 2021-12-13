package _2021.프로그래머스.Level3;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 1. priorityQueue를 사용하여 가장 야근이 많은것부터 하나씩 처리합니다.1시간당 1의 일을 소모하니 가장높은것부터 -1을 처리해줍니다.
 * 2. TestCase03의 경우 처리한값중에 -1 0보다 작은 값이 존재할 경우 가장 최솟값이 0이되기 때문에 조건을 걸어 해당 로직을 빠져나오게 하였습니다.
 * 3. PriorityQueue의 Collections.reverseOrder()를 사용하면 가장 높은 우선순위부터 처리할 수 있습니다.
 */
public class 야근지수 {
    public static void main(String[] args) {
//        solution(4, new int[]{4,3,3});
        solution(3, new int[]{1,1});
    }
    static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }
        int cnt = 0;
        while(!pq.isEmpty()){
            if(cnt == n){
                break;
            }
            pq.add(pq.poll()-1);
            cnt++;
        }
        for (Integer value : pq) {
            if(value < 0){
                answer = 0;
                break;
            }
            answer += Math.pow(value, 2);
        }

        System.out.println(answer);

        return answer;
    }
}
