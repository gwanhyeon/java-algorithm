package _2024.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 나누어떨어지는숫자배열 {
    public static void main(String[] args) {
        int[] arr = {5,9,7,10};
        int divisor = 5;

        int[] answer = Arrays.stream(arr)
                .filter(num -> num % divisor == 0)
                .sorted()
                .toArray();

        System.out.println(answer.length == 0 ? -1 : answer);
    }
}
