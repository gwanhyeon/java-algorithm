package _2021.스터디.스터디_GN.스터디_GN_11주차;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 전화번호목록 {
    public static void main(String[] args) {
//        solution(new String[]{"119", "97674223", "1195524421"});
//        solution(new String[]{"97674223", "1195524421","119"});
        System.out.println(solution(new String[]{"112","44","4544"}));
    }

    static boolean solution(String[] phone_book) {
        // "119", "97674223", "1195524421"
        Arrays.sort(phone_book);
        Set<String> hs = new HashSet<>();
        hs.add(phone_book[0]); // 119
        StringBuilder sb;
        for(int i=1; i<phone_book.length; i++){
            sb = new StringBuilder();
            // 1195524421
            for(char c : phone_book[i].toCharArray()){
                sb.append(c);
                // 1 + 1 + 9
                if (hs.contains(sb.toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}
