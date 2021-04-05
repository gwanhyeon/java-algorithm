package 스터디.스터디_GN.스터디_GN_15주차;

/**
 * 1.문제풀이시간: 20분
 * 2.컴퓨팅사고
 * (1) 각각의 문자열을 문자로 변환하여 소문자로 변경하고 ""로 split 진행
 * (2) blank가 true인 경우에만 대문자로 처리하고 그게 아니면 해당 소문자를 넣어줍니다.
 */
public class JadenCase문자열만들기 {
    public static void main(String[] args) {
        solution("3people unFollowed me");
    }
    static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        // 각각의 문자열을 문자로 변환하여 소문자로 변경하고 ""로 split 진행
        String[] splitStr = s.toLowerCase().split("");

        // 3 p e o p l e u n F o l l o w e d m e => String
        boolean isCheckBlank = true;
        for (String s1 : splitStr) {
            // blank가 true인 경우에만 대문자로 처리하고 그게 아니면 해당 소문자를 넣어줍니다.
            answer.append(isCheckBlank ? s1.toUpperCase() : s1);
            // 3people unFollowed
            isCheckBlank = " ".equals(s1);
        }
        System.out.println(answer.toString());
        return answer.toString();
    }
}
