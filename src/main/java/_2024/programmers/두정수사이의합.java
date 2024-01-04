package _2024.programmers;

public class 두정수사이의합 {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        long answer = 0;
        int start = a;
        int end = b;
        if(a > b){
            start = b;
            end = a;
        }
        for(int i=start; i<=end; i++){
            answer += i;
        }
        System.out.println(answer);
    }
}
