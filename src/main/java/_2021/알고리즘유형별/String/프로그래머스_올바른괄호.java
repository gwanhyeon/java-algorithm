package _2021.알고리즘유형별.String;

import java.util.Stack;

//comment: 주의! stack의 isempty의 조건을 처리 할때 가장 먼저 처리해야한다. if조건에 만약 peek()보다 뒤에 있게 되면 에러가 나오게 된다.

public class 프로그래머스_올바른괄호 {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
    }

    static void solution1(String s) {
        dfs(s, 0, "");
    }

    /* 재귀 호출로 풀기 */

    private static void dfs(String s, int cnt, String str) {

        if(s.length() == cnt){
            System.out.println(str);
            return;
        }
        dfs(s, cnt+1, str+"(");
        dfs(s, cnt+1 , str+")");
    }

    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack();
        boolean tf = true;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')' ){
                if(!stack.isEmpty() && stack.peek() == '(' ){
                    stack.pop();
                }else {
                    tf = false;
                    break;
                }
            }
        }
        if(stack.size() > 0){
            tf = false;
        }
        answer = tf;
        return answer;
    }
}
