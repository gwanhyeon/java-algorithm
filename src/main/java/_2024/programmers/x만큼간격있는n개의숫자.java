package _2024.programmers;

public class x만큼간격있는n개의숫자 {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        long[] answer = new long[n];
        long num = x;
        for(int i=0; i<answer.length; i++){
            answer[i] = num;
            num += x;
        }
        for (long l : answer) {
            System.out.println(l);
        }
    }
}
