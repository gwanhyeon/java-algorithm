package _2024.programmers_highscore;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue<Integer>();

        pq.add(3);
        pq.add(1);
        pq.add(5);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
}
