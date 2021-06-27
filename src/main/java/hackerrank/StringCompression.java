package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aaabbbccc";

        Map<Character, Integer> m = new HashMap<>();

        for(char c : s.toCharArray()){
            if(!m.containsKey(c)){
                m.put(c, 1);
            }else {
                m.put(c, m.get(c) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        m.forEach((key ,value ) -> {
            sb.append(value.toString() + key);
        });
        System.out.println(sb.toString());

    }
}
