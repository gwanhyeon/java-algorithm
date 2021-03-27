package 스터디.스터디_GN.스터디_GN_14_주차;

public class 이진변환반복하기_kgh {
    public static void main(String[] args) {
        solution("110010101001");
        solution("01110");
        solution("1111111");
    }
    static int[] solution(String s) {
        int[] answer = new int[2];
        int convertCnt = 0;
        while(true) {
            if("1".equals(s)) break;
            int notConvertStrLen = s.length();
            s = s.replaceAll("0", "");
            answer[1] += notConvertStrLen-s.length();
            s = Integer.toBinaryString(s.length());
            convertCnt++;
        }
        answer[0] = convertCnt;
        return answer;
    }
}
