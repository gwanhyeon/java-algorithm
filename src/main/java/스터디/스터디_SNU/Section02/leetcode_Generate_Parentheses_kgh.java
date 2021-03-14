package 스터디.스터디_SNU.Section02;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/generate-parentheses/
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

    private static void dfs(int cnt, int n, String s) {
        if(cnt == 2 * n){
            if(validString(s)){
                answer.add(s);
            }
            return;
        }
        dfs(cnt+1, n, s+"(");
        dfs(cnt+1, n, s+")");
    }

    private static boolean validString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(') stack.add(')');
            else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
