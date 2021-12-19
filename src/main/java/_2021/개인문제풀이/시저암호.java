package _2021.개인문제풀이;

public class 시저암호 {
    public static void main(String[] args) {
        String s = "AB";
        int n = 1;
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char alpha = s.charAt(i);
            if(alpha == ' '){
                answer.append(" ");
            }else {

                if(Character.isLowerCase(alpha)){
                    if(alpha + n > 'z'){
                        answer.append((char)(alpha+n-26));
                    }else {
                        answer.append((char)(alpha+n));
                    }

                }
                if(Character.isUpperCase(alpha)){
                    if(alpha + n > 'Z'){
                        answer.append((char)(alpha+n-26));
                    }else {
                        answer.append((char)(alpha+n));
                    }
                }
                /*
                if(s.charAt(i) >='a' && s.charAt(i) <= 'Z'){
                    answer.append((char) ((s.charAt(i)-26)+n));
                }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                    answer.append((char) ((s.charAt(i)-26)+n));
                }
                 */
            }
        }
        System.out.println(answer);
    }
}
