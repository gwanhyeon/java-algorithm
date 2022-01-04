package _2022.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
boj 14888 연산자끼워넣기
 */
public class boj14888 {
    static int[] numbers;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        answer = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        dfs(numbers[0], a,b,c,d,numbers,n,1);
        System.out.println(Collections.max(answer));
        System.out.println(Collections.min(answer));

    }

    private static void dfs(int sum, int a, int b, int c, int d, int[] numbers, int n, int idx) {
        if(idx == n){
            answer.add(sum);
            return;
        }

        if(a > 0) {
            dfs(sum + numbers[idx], a - 1, b, c, d, numbers, n, idx + 1);
        }
        if(b > 0){
            dfs(sum-numbers[idx], a, b-1, c, d, numbers, n, idx+1);
        }
        if(c > 0){
            dfs(sum*numbers[idx], a, b, c-1, d, numbers, n, idx+1);
        }
        if(d > 0) {
            dfs(sum / numbers[idx], a, b, c, d - 1, numbers, n, idx + 1);
        }
    }
}
