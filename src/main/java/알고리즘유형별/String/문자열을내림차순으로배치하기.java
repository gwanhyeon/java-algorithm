package 코딩테스트.String;

import java.util.Arrays;
public class 문자열을내림차순으로배치하기 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        String answer = "";
        char[] ch = s.toCharArray();


        Arrays.sort(ch);
        for(int i=ch.length-1; i >= 0; i--){
            answer += ch[i];
        }

        System.out.println(answer);

    }
}

/*
sort(T[] a, Comparator<? super T> c)
Arrays.sort(a, Collections.reverseOrder());
Collections.sort(list, Collections.reverseOrder());
 */