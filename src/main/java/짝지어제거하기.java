import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args){
        String s = new String("aabbaa");
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));


        for(int i=1; i<s.length(); i++){
            if(!stack.empty() && s.charAt(i) == stack.peek()){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }

        if(stack.empty()){
            answer = 1;
        }else {
            answer = 0;
        }
        System.out.println(answer);
    }

}
