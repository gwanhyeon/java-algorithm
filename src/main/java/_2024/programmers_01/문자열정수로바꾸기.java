package _2024.programmers_01;

public class 문자열정수로바꾸기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution());

    }
    static class Solution{
        int solution(){
            String s = "-1234";
            return Integer.parseInt(s);
        }

    }
}
