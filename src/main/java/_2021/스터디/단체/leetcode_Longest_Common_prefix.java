package _2021.스터디.단체;

/**
 * 1. 문제 풀이 시간: 40분
 * 2. 컴퓨팅 사고
 * (1)기준이 되는 문자열을 기준값으로 설정합니다. 예) str[0]
 * (2)indexOf 함수를 사용하여 값이 일치하면 0, 그게 아니라면 -1을 반환합니다.
 * (3)값이 일치할때까지 기준의 되는 문자열인 prefix을 뒤에서부터 하나씩 줄여나가면서 진행합니다.
 * 예)
 * 첫번째 경우
 * flower flow 의 값이 있다고 가정하면 flower 가 prefix로 설정되며 flower -> flowe -> flow 로 문자열을 자르게 되면서 같아지는 경우일때 루프를 빠져나옵니다.
 * 두번째 경우
 * 이제 prefix값이 flow로 된 상태이므로 flow와 flight를 비교진행을 합니다. flow -> flo -> fl 로 진행하면서 flight의 [fl]과 값이 같으므로 해당 루프를 빠져나오면서
 * 최종적으로 prefix 공통이 되는 문자열을 반환할 수 있습니다.
 *
 */
public class leetcode_Longest_Common_prefix {
    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            // 기준이되는 prefix값과 일치할때까지 루프를 진행합니다.
            while (strs[i].indexOf(prefix) != 0) {
                // 값을 뒤에서부터 하나씩 자르면서 비교해나갑니다.
                prefix = prefix.substring(0, prefix.length()-1);
                // 빈 상태에서 substring을 자르게되면 Error가 발생합니다.
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
