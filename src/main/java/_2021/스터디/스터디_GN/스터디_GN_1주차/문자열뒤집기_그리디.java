package _2021.스터디.스터디_GN.스터디_GN_1주차;

public class 문자열뒤집기_그리디 {
    public static void main(String[] args) {


        solution("0001100");
        solution1("0001100");
    }
    private static void solution1(String str){

        int one = 0;
        int zero = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0'){
                one++;
            }else {
                zero++;
            }
        }
        System.out.println(one + " " + zero);
    }
    private static void solution(String s) {

        int zero_cnt = 0;
        int one_cnt = 0;


        // 맨처음에 0으로 시작하는지 1로 시작하는지를 체크한다. 그 이유는 0으로 진행되는 문자열이 있을 수 있고, 1로 시작되는 문자열이 있을 수 있기 때문이다.
        if(s.charAt(0) == '1'){
            zero_cnt++;
        }else {
            one_cnt++;
        }

        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) != s.charAt(i+1)){
                if(s.charAt(i+1) == '1'){
                    zero_cnt++;
                }else {
                    one_cnt++;
                }
            }
        }
        System.out.println(Math.min(zero_cnt, one_cnt));
    }
}
