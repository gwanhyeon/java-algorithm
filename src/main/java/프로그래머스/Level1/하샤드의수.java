package 프로그래머스.Level1;

/**
 * 풀이시간 3분
 */
public class 하샤드의수 {
    public static void main(String[] args) {
        solution(10);
    }
    static boolean solution(int x) {
        String[] tmp = String.valueOf(x).split("");
        boolean answer = false;
        String numbers = Integer.toString(x);
        int sum = 0;

        for(int i=0; i<numbers.length(); i++){
            sum += numbers.charAt(i)-'0';
        }
        return x % sum == 0;
    }
}
