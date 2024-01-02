package _2024.programmers;

import java.util.Locale;

public class 문자열내p와y의개수 {
    public static void main(String[] args) {
        String s = "pPoooyY";
        int answer = 0;
        s = s.toLowerCase();

        char[] c = s.toCharArray();

        for(int i=0; i<c.length; i++){
            if(c[i] == 'p'){
                answer++;
            }else if(c[i] == 'y'){
                answer--;
            }
        }
        System.out.println(answer);

        if(answer == 0){
            System.out.println(true);
        }else {
            System.out.println(false);
        }


    }
}
