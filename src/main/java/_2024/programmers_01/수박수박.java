package _2024.programmers_01;

import java.util.stream.IntStream;

public class 수박수박 {
    public static void main(String[] args) {
        int n = 3;

        String answer = "";
        if(n%2 == 0){
            for(int i =0; i<n/2; i++){
                answer += "수박";
            }
        }else {
            for(int i =0; i<n/2; i++){
                answer += "수박";
            }
            answer += "수";
        }
        System.out.println(answer);
    }
}
