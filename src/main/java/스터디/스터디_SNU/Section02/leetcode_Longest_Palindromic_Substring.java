package 스터디.스터디_SNU.Section02;

import java.util.HashSet;

public class leetcode_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        leetcode_Longest_Palindromic_Substring a = new leetcode_Longest_Palindromic_Substring();
        //System.out.println(a.longestPalindrome("babad"));
        System.out.println(a.palindrome("babasdadad"));
    }

    // comment 부분문자열 어떻게 구해야하나!!!!!!! 필수문제 부분문자열 + 펠린드롬 문제
    public String longestPalindrome(String s) {

        HashSet<Character> hs = new HashSet<>();





        return s;
    }


    /*
    palindrome function
     */
    public boolean palindrome(String s){
        boolean tf = false;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            sb1.append(s.charAt(i));
            sb2.append(s.charAt(s.length()-(i+1)));
        }
        if(sb1.toString().equals(sb2.toString())){
            tf = true;
        }else {
            tf = false;
        }
        return tf;

    }
}
