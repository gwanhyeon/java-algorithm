package _2022.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] brackets = br.readLine().split("");
            int bracketSize = brackets.length;
            Stack<String> stack = new Stack<>();
            boolean isValid = false;
            for (int j = 0; j < bracketSize; j++) {
                if ("(".equals(brackets[j])) {
                    stack.add(brackets[j]);
                } else if (")".equals(brackets[j])) {
                    if (!stack.isEmpty() && "(".equals(stack.peek())) {
                        stack.pop();
                    }
                    /*else {
                        isValid = true;
                    }*/
                }
            }
            if (stack.isEmpty() && !isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
