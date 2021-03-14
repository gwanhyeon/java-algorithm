package 스터디.스터디_GN.스터디_GN_9주차;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        solution(2, 10,new int[]{7,4,5,6});
    }
    static int solution(int bridge_length, int weight, int[] truck_weights) {

        int answer = 0;
        int sum = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }
        int idx = 0;
        while (!q.isEmpty()) {
            int popped = q.poll();
            sum -= popped;
            // idx값 처리
            if (idx < truck_weights.length) {
                if (sum + truck_weights[idx] <= weight) {
                    q.offer(truck_weights[idx]);
                    sum += truck_weights[idx];
                    idx++;
                } else {
                    q.offer(0);
                }
            }
            answer++;
        }
        System.out.println(answer);
        return answer;
    }
}
