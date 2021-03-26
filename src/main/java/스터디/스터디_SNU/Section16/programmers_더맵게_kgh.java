package 스터디.스터디_SNU.Section16;

import java.util.PriorityQueue;

public class programmers_더맵게_kgh {
    public static void main(String[] args) {
//        solution(new int[]{1,2,3,9,10,12}, 7);
//        solution(new int[]{1,1,1,1,1,1}, 100);
//        solution(new int[]{8, 10, 11}, 7);
//        solution(new int[]{1,1,100}, 3);
        // 예외 케이스
//        scoville = {8, 10, 11} 인데 K = 7 인 경우 0 이나와야 합니다.
        // 16번 테스트 케이스
        //scoville : [1,2,3] K : 11
        //
        //이 케이스를 통과한다면 16번 통과할듯합니다..
        //딱맞게 K 를 통과하는 음식이 하나로 만들어지는 경우를 따지는 테스트인듯하네요.
        //저도 이거 때매 조금 헤메였기때문에 올려봅니다..
        //
        //작성중인
        solution(new int[]{1,2,3}, 11);
        // 1 + 4
        // 5 + 6


    }
    static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int sco : scoville) {
            pq.add(sco);
        }
        while(!pq.isEmpty() && pq.peek() < K){
            int firstFood = pq.remove();
            if(pq.size() == 0){
                answer = -1;
            }
            int secondFood = pq.remove();
            int totalFoods = (firstFood + (secondFood * 2));
            answer++;
            pq.add(totalFoods);
        }
//        System.out.println("answer = " + answer);
        return answer;
    }
}
