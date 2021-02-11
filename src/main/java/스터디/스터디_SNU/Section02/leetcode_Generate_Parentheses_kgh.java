package 스터디.스터디_SNU.Section02;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1. 문제 풀이 시간: 30분
 * 2. 가능한 괄호조합 찾기 문제(dfs + valication check)
 * 3. 시간복잡도 O(N+N) 재귀호출 + 타당성 체크 O(N) => O(3N) => O(N)
 */

public class leetcode_Generate_Parentheses_kgh {
    static List<String> answer;

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        answer.clear();
        System.out.println(generateParenthesis(3));
    }

    static List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        dfs(0, n, "");
        return answer;
    }
    private static void dfs(int cnt, int n, String str) {
        if(cnt == n*2){
            if(validString(str)){
                answer.add(str);
            }
            return;
        }
        dfs(cnt+1, n, str+"(");
        dfs(cnt+1, n, str+")");
    }

    private static boolean validString(String str) {
        Stack<Character> stack = new Stack<>();
        boolean tf = true;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.add(str.charAt(i));
            }
            if(str.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
