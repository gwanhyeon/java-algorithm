package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aaabbbcccaaaaaaaaa";
        System.out.println(compression1(s));
        System.out.println(compression2(s));
        System.out.println(compression3(s));
    }
    static public String compression1(String s){

        Map<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            m.merge(c, 1, (v1, v2) -> v1 + v2);
        }
        StringBuilder sb = new StringBuilder();
        m.forEach((k, v) -> {
            sb.append(v.toString() + k);
        });
        return sb.toString();
    }
    static public String compression2(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < str.length()) {
            char c = str.charAt(i);
            int counter = 0;
            // 遍历相同字母的子串，并记录个数
            while (i < str.length() && str.charAt(i) == c) {
                counter++;
                i++;

            }
            sb.append(c).append(counter);
        }
        if (sb.length() < str.length()) {
            return sb.toString();
        }

        return str;
    }
    static public String compression3(String str){
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while(i < str.length()){
            char c = str.charAt(i);
            int countNumber = 0;

            while(i < str.length() && str.charAt(i) == c){
                countNumber++;
                i++;
            }
            sb.append(c).append(countNumber);
        }
        return sb.length() < str.length() ? sb.toString() : str;
    }
}
