package _2024.programmers;

public class 자릿수더하기 {
    public static void main(String[] args) {
        int n = 123;
        int answer = 0;
        String s = Integer.toString(n);

        for(int i=0; i<s.length(); i++){
            answer += (s.charAt(i)-'0');
        }
        System.out.println(answer);
    }
}
