package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long gcd = getGcd(x,y);
            long lcm = getLcm(gcd, x,y);
            System.out.println(lcm);
        }
    }

    private static long getGcd(long n, long m) {
        if(m == 0){
            return n;
        }
        return getGcd(m, n%m);
    }
    private static long getLcm(long gcd, long n, long m){
        return gcd * (n / gcd) * (m / gcd);
    }
}
