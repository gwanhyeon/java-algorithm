package _2021.스터디.스터디_SNU.Section11;

import java.util.PriorityQueue;

/**
 * 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현
 * 1. 문제풀이시간: 40분
 * 2. 컴퓨팅사고
 * (1)최댓값, 최솟값을 구해야하는 문제이므로 최대힙, 최소힙을 두개선언 하여 max,min값을 구해주었습니다.
 * (2)priority queue Comparable을 사용하여 최대힙의 경우, 최소힙의 경우로 toCompare함수를 만들어주었습니다.
 * 최소힙: 작은순, 최대힙: 큰순
 *
 * 5 8 10 -1
 * 10 8 5 -1 pop() 10
 * -1 5 8 10 pop() -1
 *
 * (3)
 * "I 숫자"가 올 경우 최대힙과 최소힙에 모두 값을 넣어주었습니다.
 * "D 1" 이 올 경우 최대힙의 첫번째 값을 삭제하고, 최소힙의 마지막인덱스에 해당하는값을 동시에 삭제하였습니다.
 * "D -1" 이 올 경우 최소힙의 첫번째 값을 삭제하고, 최대힙의 마지막인덱스에 해당하는값을 동시에 삭제하였습니다.
 * (4) 만약 둘중 하나라도 빈값이 있을경우 0,0을 반환하였고, 그게 아니라면 최대값, 최소값을 answer에 담아 리턴을 해주었습니다.
 *
 * 3. 시간복잡도
 * O(N)
 */
public class programmers_이중우선순위큐_kgh {
    public static void main(String[] args) {
        solution(new String[]{"I 7","I 5","I -5","D -1"});
        solution(new String[]{"I 16","D 1"});
        solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
    }

    static int[] solution(String[] operations) {
        PriorityQueue<MaxHeap> maxHeap = new PriorityQueue();
        PriorityQueue<MinHeap> minHeap = new PriorityQueue();
        int[] answer = {0,0};
        for(int i=0; i<operations.length; i++){
            String[] s = operations[i].split(" ");
            if(s[0].equals("I")){
                maxHeap.add(new MaxHeap(Integer.parseInt(s[1])));
                minHeap.add(new MinHeap(Integer.parseInt(s[1])));
            }else if(s[0].equals("D")){
                if(s[1].equals("1") && !maxHeap.isEmpty()){
                    maxHeap.poll();
                    minHeap = removelast(minHeap);
                }else if(s[1].equals("-1") && !minHeap.isEmpty()){
                    minHeap.poll();
                    maxHeap = removelast(maxHeap);
                }
            }
        }
        if(maxHeap.isEmpty() || minHeap.isEmpty()){
            return answer;
        }

        answer[0] = maxHeap.peek().value;
        answer[1] = minHeap.peek().value;
        System.out.println("answer = " + answer[0]);
        System.out.println("answer = " + answer[1]);
        return answer;
    }
    static PriorityQueue removelast(PriorityQueue pq)
    {
        PriorityQueue pqTmp = new PriorityQueue<>();
        while(pq.size() > 1)
        {
            pqTmp.add(pq.poll());
        }
        pq.clear();
        return pqTmp;
    }

    private static class MaxHeap implements Comparable<MaxHeap>{
        int value;
        public MaxHeap(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(MaxHeap o) {
            if(this.value < o.value){
                return 1;
            }else {
                return -1;
            }
        }
    }

    private static class MinHeap implements Comparable<MinHeap>{
        int value;
        public MinHeap(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(MinHeap o) {
            if(this.value < o.value){
                return -1;
            }else {
                return 1;
            }
        }
    }
}
