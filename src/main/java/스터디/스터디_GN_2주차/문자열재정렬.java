package 스터디.스터디_GN_2주차;

import java.util.Arrays;

/**
 * 1.문제풀이 시간: 8분
 * 2.컴퓨팅사고
 * 정규표현식을 사용하여 대문자와 숫자를 분리한 후 대문자는 정렬을 통해 A-Z 오름차순 정렬을 진행하고, 나머지숫자들은 각 자리수를 더하여서 대문자의 문자열과 각 자리수의 합을 문자열로 변환하여 결과로 출력합니다.
 * 3.시간복잡도
 * O(number.length)
 */
public class 문자열재정렬 {
    public static void main(String[] args) {
        solution("K1KA5CB7");
        solution("AJKDLSI412K4JSJ9D");
    }

    private static void solution(String str) {
        String upperCase = str.replaceAll("[^A-Z]","");
        String number = str.replaceAll("[^0-9]","");
        int sum = 0;
        char[] upperCaseChar = upperCase.toCharArray();

        Arrays.sort(upperCaseChar);
        String convertUpperCase = new String(upperCaseChar);

        for(char c : number.toCharArray()){
            sum += Integer.parseInt(String.valueOf(c));
        }

        String answer = convertUpperCase + Integer.toString(sum);
        System.out.println(answer);
    }
}
