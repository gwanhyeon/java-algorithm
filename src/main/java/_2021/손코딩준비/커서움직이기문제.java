package _2021.손코딩준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 커서움직이기문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String input = br.readLine();
        for(char c : input.toCharArray()){
            leftStack.add(c);
        }
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String cmd = br.readLine();
            if(cmd.startsWith("L")){
                if(!leftStack.isEmpty()){
                    rightStack.add(leftStack.pop());
                }
            }else if(cmd.startsWith("D")){
                if(!rightStack.isEmpty()){
                    leftStack.add(rightStack.pop());
                }
            }else if(cmd.startsWith("B")){
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }
            }else if(cmd.startsWith("P")){
                String[] tmp = cmd.split(" ");
                leftStack.add(tmp[1].charAt(0));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!leftStack.isEmpty()){
            rightStack.add(leftStack.pop());
        }
        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        System.out.println(sb.toString());
        /*
abcd
4
P x
L
P y
A T
         */
    }
}
