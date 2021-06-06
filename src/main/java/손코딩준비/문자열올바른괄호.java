package 손코딩준비;

import java.util.Stack;

public class 문자열올바른괄호 {
    public static void main(String[] args) {
        String s = "()()";
        System.out.println("isValid = " + isValid(s));
        String a = "aaaa";
        char cc = 'a';
        String aa = String.valueOf(cc);
        System.out.println("aa = " + aa);
        char c = a.toCharArray()[0];
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.add(')');
            }else if(c == '['){
                stack.add(']');
            }else if(c == '{'){
                stack.add('}');
            }else if(stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
