package _2021.스터디.스터디_SNU.Section04;

// https://medium.com/@denny6389147/leetcode-647-palindromic-substrings-medium-2a4451c7bef4
/**
 * 1. 문제풀이시간: 50분
 * 2. 홀수,짝수 팰린드롬의 경우를 나누어서 처리한다. 그리고 각 문자열의 start,end포인트를 설정하고 범위를 체크한다.
 * 첫문자와 끝문자가 그값은 팰린드롬으로 판단할 수 있다. 그게 아닌경우 다음 경우의 수로 이동한다.
 * 하위문자열이 팰린드롬인 경우 팰린들모의 개수를 리턴한다.
 * 3. 시간복잡도 O(2 * s.length) => O(s.length)
 */
public class leetcode_palindromic_substrings_kgh {
    public static void main(String[] args) {
//        countSubstrings("abc");
        System.out.println();
        countSubstrings("aaa");
        System.out.println();
//        countSubstrings("abacde");
    }

    private static void countSubstrings(String s) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            // 짝홀에 따라 다르기 때문에 어차피 cnt가 0으로 반환되니까 이렇게 처리하면 모든 경우의 수가 없어진다.
            cnt += palindromes(s, i, i);
            System.out.println("cnt => " + cnt);
            cnt += palindromes(s, i, i+1);
            System.out.println("cnt => " + cnt);
        }
        System.out.print(cnt);
    }

    // start = 1 end 1 홀수
    // a == a, start =0, end = 2
    private static int palindromes(String s, int start, int end) {
        int cnt = 0;
//        System.out.println(start + "" + end);
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
            cnt++;
//            System.out.println(cnt);
//            if(start >= 0 && end < s.length()) System.out.println(start + " " + end);
        }
//        System.out.print(s.substring(start+1, end));
//        System.out.println((start+1) + " " + (end-1));
        return cnt;
    }
}
