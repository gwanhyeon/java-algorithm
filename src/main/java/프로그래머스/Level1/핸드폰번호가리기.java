package 프로그래머스.Level1;

/**
 * 소요시간: 5분 정규표현식
 *
 */
public class 핸드폰번호가리기 {
    public static void main(String[] args) {
        solution("01033334444");
    }
    static void solution(String phone_number){
        String answer = phone_number.substring(0, phone_number.length()-4).replaceAll("[^a-zA-Z]", "*");
        answer += phone_number.substring(phone_number.length()-4);
        System.out.println(answer);
    }
}
