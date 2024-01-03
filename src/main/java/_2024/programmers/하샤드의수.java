package _2024.programmers;

public class 하샤드의수 {
    public static void main(String[] args) {
        int n = 18;
        boolean answer = false;
        if(n % getDigistSum(n) == 0){
            answer = true;
        }
        System.out.println(answer);

    }

    private static int getDigistSum(int n) {
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;

    }
}
