package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_2502_2 {
    static int MAX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        MAX = K / D;

        for(int i=1; i<=MAX; i++){

        }

    }
}
