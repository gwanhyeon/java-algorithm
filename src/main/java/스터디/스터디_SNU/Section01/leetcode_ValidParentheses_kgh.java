package 스터디.스터디_SNU.Section01;
import java.util.*;

// https://leetcode.com/problems/valid-parentheses/
/**
 * 1. 문제풀이 시간: 20분
 * (1). 스택을 이용하여 스택에 담긴 맨위에 값과 현재 들어오는 값과의 비교를 진행한다.
 * (2). 만약 괄호쌍의 짝은 맞으니 올바른 괄호가 아닐 경우에는 false를 리턴한다.
 * (3). 마지막으로 스택이 비어있다는것은 현재 모든값의 짝이 맞는것을 의미하므로 true를 리턴한다.
 *
 */
public class leetcode_ValidParentheses_kgh {
    public static void main(String[] args) {
        System.out.println(isValidStack1("([)]"));

    }
    static boolean isValidStack(String s) {
        Stack<Character> stack = new Stack();
        boolean answer = false;

        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.add(c);
            }else if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else {
                    return false;
                }
            }else if(c == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else {
                    return false;
                }
            }else if(c == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }
            }
        }
        answer = stack.isEmpty() ? true : false;
        return answer;
    }

    static boolean isValidStack1(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(') stack.add(')');
            else if(c == '{') stack.add('}');
            else if(c == '[') stack.add(']');
            else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}