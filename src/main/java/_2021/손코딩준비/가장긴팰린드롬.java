package _2021.손코딩준비;

public class 가장긴팰린드롬 {

    static int start = 0;
    static int end = 0;
    static int n;
    public static void main(String[] args) {
        String s = "aba";
        n = s.length();

        for(int i=0; i<s.length(); i++) {

            int oddLen = palindrome(s, i, i);
            int evenLen = palindrome(s, i, i + 1);
            int maxLen = Math.max(oddLen, evenLen);

            if (maxLen > end - start) {
                start = i - ((maxLen - 1) / 2);
                end = i + (maxLen / 2);
            }
        }
    }
    private static int palindrome(String s, int start, int end) {

        while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
}
