package _2024.programmers;

public class 정수의제곱근판별 {
    public static void main(String[] args) {
        int n = 121;
        int x = (int)Math.sqrt(n);
        long answer = -1;
        if(Math.pow(x, 2) == n){
            answer = (long)Math.pow(x+1,2);
        }
        System.out.println(answer);
    }
}
