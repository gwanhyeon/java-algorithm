package _2021.개인문제풀이;

import java.util.Stack;

/* comment 풀이 방식
1.스택이 비어있지 않고 스택위에 있는 값과 현재 값이 같으면 스택에 있는 값을 빼줍니다. 즉, 쌍을 이룬다는 뜻이고, 그렇지 않으면 쌍을 이루지않습니다.
2. 만약 스택이 비어있지 않으면 answer = 0으로 변경해주고 stack이 비어있지않으면 1 을 리턴해줍니다.
 */
public class 짝지어제거하기_stack {
    public static void main(String[] args){
        String s ="aabbaa";
        int answer = 0;
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty()){
            answer = 0;
        }else {
            answer = 1;
        }
        System.out.println(answer);

    }

}
