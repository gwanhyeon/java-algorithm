package _2021.Codility;

import java.util.LinkedList;

/**
 * linkedlist를 사용하여 뒤에있는값들을 shift해주면 간단하게 풀리는 문제.
 *
 */
public class CyclicRotation_lesson02 {
    public static void main(String[] args) {
        solution(new int[]{3, 8, 9, 7, 6},3);
    }
    static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        LinkedList<Integer> linkedList = new LinkedList<>();
        if(A.length == 0){
            return A;
        }
        for(int i=0; i<A.length; i++){
            linkedList.add(A[i]);
        }
        for(int i=0; i<K; i++){
            int last = linkedList.removeLast();
            linkedList.addFirst(last);
        }
        int[] answer = new int[linkedList.size()];
        int idx = 0;
        for (Integer integer : linkedList) {
            answer[idx++] = integer;
        }
        return answer;
    }
}
