package _2024.programmers_01;

import java.util.Arrays;

public class 없는숫자더하기 {
    public static void main(String[] args) {
        int[] match = {1,2,3,4,5,6,7,8,9};
        int[] numbers = {1,2,3,4,6,7,8,0};

        int answer = Arrays.stream(match)
                .filter(num -> Arrays.stream(numbers).noneMatch(num2 -> num == num2))
                .sum();

        System.out.println(answer);


    }
}
