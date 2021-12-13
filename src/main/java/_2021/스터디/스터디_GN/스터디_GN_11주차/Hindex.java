package _2021.스터디.스터디_GN.스터디_GN_11주차;

import java.util.Arrays;

public class Hindex {
    public static void main(String[] args) {
        solution(new int[]{3,0,6,1,5});
    }
    static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        // 3,0,6,1,5
        // 0 1 3 5 6
        // 1-5 =>
        for(int i=0; i<citations.length; i++){
            int h = citations.length-i;
            // 0 1 3 5 6
            // 0 -> 6
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        return answer;
    }

}
