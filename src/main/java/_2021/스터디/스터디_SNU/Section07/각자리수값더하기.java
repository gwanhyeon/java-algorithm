package _2021.스터디.스터디_SNU.Section07;

public class 각자리수값더하기 {
    public static void main(String[] args) {
        solution(5555);
    }

    private static void solution(int num) {

        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num = num / 10;
        }
        System.out.println(sum);
    }
}
