package _2024.programmers_01;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class 내적 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};

        long sum = IntStream.range(0, a.length)
                .mapToLong(i -> a[i] * b[i])
                .sum();
        System.out.println(Long.valueOf(sum).intValue());
    }
}
