package 스터디.스터디_GN_2주차;

/**
 * 1. 풀이시간: 5분
 * 2. 컴퓨팅 사고 : Integer to String 이후에 수의 절반만큼 더한값의 비교를 통해 "LUCKY", "READY"를 확인하였습니다.
 * 3. 시간복잡도 O(N)
 */
public class 럭키스트레이트 {
    public static void main(String[] args) {
        solution(123402);
    }

    private static void solution(int n) {
        String str = Integer.toString(n);
        int len = str.length() / 2;
        String answer = "";
        int answer_half = 0;
        int answer_full = 0;
        for(int i=0; i<len; i++){
            answer_half += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        for(int i=len; i<str.length(); i++){
            answer_full += Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        if(answer_half == answer_full){
            answer ="LUCKY";
        }else {
            answer = "READY";
        }
        System.out.println(answer);
    }
}
