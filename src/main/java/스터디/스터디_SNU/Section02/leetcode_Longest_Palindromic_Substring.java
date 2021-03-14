package 스터디.스터디_SNU.Section02;

public class leetcode_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        leetcode_Longest_Palindromic_Substring a = new leetcode_Longest_Palindromic_Substring();
        System.out.println(a.longestPalindrome("babad"));

    }

    // comment 부분문자열 어떻게 구해야하나!!!!!!! 필수문제 부분문자열 + 펠린드롬 문제
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0;
        int end = 0;
        for(int i=0; i<s.length(); i++){
            int oddLen = palindrome(s, i, i);
            int evenLen = palindrome(s,i,i+1);
            int maxLen = Math.max(oddLen, evenLen);
            if(maxLen > end - start){
                start = i - ((maxLen-1) / 2);
                end = i + (maxLen/2);
            }
        }
        System.out.println(s.substring(start,end+1));
        return "";
    }
    /*
    palindrome function
     */
    public int palindrome(String s, int start, int end){
        if(s == null || start > end){
            return 0;
        }
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
}
