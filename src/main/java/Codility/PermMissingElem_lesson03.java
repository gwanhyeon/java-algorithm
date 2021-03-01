package Codility;

import java.util.Arrays;

public class PermMissingElem_lesson03 {
    public static void main(String[] args) {
        solution(new int[]{2,3,1,5});
    }
    static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        boolean[] check = new boolean[A.length+2];
        // 0, 1, 2, 3
        for(int i=0; i<A.length; i++){
            check[A[i]] = true;
        }
        int answer = 0;
        for(int i=1; i<=check.length; i++){
            if(!check[i]){
                answer = i;
                System.out.println(answer);
                return answer;
            }
        }
        return -1;
    }
}
