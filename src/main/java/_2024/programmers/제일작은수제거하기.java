package _2024.programmers;

import java.util.Arrays;

public class 제일작은수제거하기 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1};
        int minValue = Arrays.stream(arr).min().orElse(-1);
        int[] answer = Arrays.stream(arr)
                .filter(v -> v != minValue)
                .toArray();

        System.out.println(answer);

    }
}
