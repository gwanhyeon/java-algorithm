package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 1일 A
 2일 B
 3일 A+B
 4일 A+2B
 5일 2A+3B

 A[1] = 1, B[1] = 0
 A[2] = 0, B[2] = 1
 ......
 1A + 0B
 0A + 1B

 즉,
 A[D] = A[D-1] + A[D-2]
 B[D] = B[D-1] + B[D-2]
 */

public class boj_2502_2 {
    static int MAX = 35;
    static int D,K;
    static int A[];
    static int B[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[MAX];
        B = new int[MAX];

        // 몇째날까지 진행할것인지
        A[1] = 1;
        A[2] = 0;
        B[1] = 0;
        B[2] = 1;
        for(int i=3; i<=D; i++){
            A[i] = A[i-1] + A[i-2];
            B[i] = B[i-1] + B[i-2];
        }

        for(int i=1; i<=K; i++){
            int A = K-(A[D] * i);
            if(A % B[D] == 0){
                System.out.print(i + " " + (A/B[D]));
                return;
            }

        }

    }
}
