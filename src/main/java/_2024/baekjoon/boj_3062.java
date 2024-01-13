package _2024.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3062 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){
            StringBuilder sb = new StringBuilder(br.readLine().toString());
            int noneResverseNum = Integer.parseInt(sb.toString());
            sb = sb.reverse();
            int reverseNum = Integer.parseInt(sb.toString());
            int answer = noneResverseNum + reverseNum;

            sb = new StringBuilder(Integer.toString(answer));
            if(isPalindrome(sb.toString())){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        return s.equals(sb.toString());
    }

    private static boolean isPalindrome2(String s){
        int left = 0;
        int right = s.length()-1;
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
