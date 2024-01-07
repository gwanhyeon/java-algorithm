package _2024.programmers;

import java.util.stream.IntStream;

public class 음양더하기 {
    public static void main(String[] args) {

        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        // method 1
        int answer = IntStream.range(0, absolutes.length)
                .map(i -> signs[i] ? absolutes[i] : -absolutes[i])
                .sum();
        answer = 0;
        // method 2
        for (int i = 0; i < absolutes.length; i++) {
            if(signs[i]){
                answer += absolutes[i];
            }else{
                answer += -(absolutes[i]);
            }
        }

        System.out.println(answer);



    }
}
