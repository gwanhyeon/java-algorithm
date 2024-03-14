package _2024.baekjoon;

import java.util.*;
import java.io.*;
public class boj_10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String blanks = br.readLine();

        char[] c = blanks.toCharArray();

        Stack<Character> s = new Stack<>();
        int answer = 0;
        for(int i=0; i<c.length; i++){
            if(c[i] == ')' && !s.isEmpty() && s.peek() == '('){
                s.pop();
                if(c[i-1] == '('){
                    answer += s.size();
                }else {
                    answer += 1;
                }
            }else {
                if(c[i] == '(') {
                    s.push(c[i]);
                }

            }
        }
        System.out.println(answer);
    }
}
