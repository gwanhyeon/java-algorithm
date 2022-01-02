package _2022.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj15650 {
    static boolean[] isValidation;
    static LinkedList<Integer> numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isValidation = new boolean[n + 1];
        numbers = new LinkedList<>();
        dfs(n, m, 0);

    }

    private static void dfs(int n, int m, int idx) {
        if (idx == m) {
            for (int i = 0; i < numbers.size(); i++) {
                System.out.print(numbers.get(i));
            }
            System.out.println();
            return;
        }

        for (int i = idx + 1; i <= n; i++) {
            if (isValidation[i]) continue;
            isValidation[i] = true;
            numbers.add(i);
            dfs(n, m, idx + 1);
            isValidation[i] = false;
            numbers.removeLast();
        }
    }
}