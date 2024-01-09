package _2024.programmers_01;

public class 가운데글자가져오기 {
    public static void main(String[] args) {

        String s = "qwer";
        String answer = "";
        boolean isEven = s.length() % 2 == 0 ? true : false;
        int half = s.length()/2;
        if(isEven){
            answer = s.substring(half-1, half+1);
        }else {
            answer = s.substring(half, half+1);
        }
        System.out.println(answer);

    }
}
