package _2021.알고리즘유형별.Math;

import java.util.*;
public class 피보나치수5 {

    private static int fibonichi(int n) {

        if(n <= 1){
            return n;
        }

        return fibonichi(n-2) + fibonichi(n-1);

    }
    public static void main(String[] args) {

        int n;
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(fibonichi(n));
    }
}