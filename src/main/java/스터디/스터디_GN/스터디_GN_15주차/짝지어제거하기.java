package 스터디.스터디_GN.스터디_GN_15주차;

import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        solution("baabaa");
        solution("cdcd");
        solution("aaaa");
        solution("aaab");
    }
    static int solution(String s) {
        if(s.length() == 1){
            return 0;
        }
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty()|| stack.peek() != s.charAt(i)){
                stack.add(s.charAt(i));
            }else {
                stack.pop();
            }
        }
        System.out.println(stack.isEmpty() ? 1 : 0);
        return stack.isEmpty() ? 1 : 0;
        /* time aceess limit complexity
        int answer = 1;
        int cnt = 0;
        while(s.length() != 0){
            for(int i=0; i<s.length()-1; i++){
                if(s.charAt(i) == s.charAt(i+1)){
                    s = s.substring(0,i) + s.substring(i+2);
//                    System.out.println("s = " + s);
                    break;
                }
            }
            if(s.length() == 1 || cnt == s.length()){
                answer = 0;
                break;
            }
            cnt++;
        }
        System.out.println(answer);
        return answer;

         */
    }

}
