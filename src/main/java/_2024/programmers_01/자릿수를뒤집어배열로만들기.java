package _2024.programmers_01;

public class 자릿수를뒤집어배열로만들기 {
    public static void main(String[] args) {
        long n = 12345;
        StringBuilder sb = new StringBuilder(Long.toString(n));
        String s= sb.reverse().toString();

        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            answer[i] = Character.getNumericValue(s.charAt(i));
        }

        for (int i : answer) {
            System.out.println(i);
        }

    }
}
