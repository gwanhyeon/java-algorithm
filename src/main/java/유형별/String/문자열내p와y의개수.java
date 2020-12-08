package String;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class 문자열내p와y의개수 {
    public static void main(String[] args) {

        String s = "pPoooyY";
        s = s.toLowerCase();
        Boolean answer = false;
        int cnt = 0;
        for(int i=0; i<s.length(); i++){

            if(s.charAt(i) == 'p'){
                cnt++;
            }else if(s.charAt(i) == 'y'){
                cnt--;
            }
            if(i == s.length()-1){
                if(cnt == 0){
                    answer = true;
                }
            }
        }
        System.out.println(answer);

    }
}
