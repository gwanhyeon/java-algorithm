package _2021.스터디.스터디_GN.스터디_GN_10주차;

/*
https://ukyonge.tistory.com/197

23563850 135 에서 k = 3 4자리 맨 뒤 1,3,5를 제외한 숫자중에 가장 큰 수를 찾는다.
23563850 135  8+
235638501 35 8+5
2356385013 5 8+5+3
23563850135 8+5+3+5
=> 8535
23563850 ==>  8이다.answer = "8" 오른쪽부터 다시 탐색을 한다.
50135중에 맨뒤 2개를 제외하고 가장 큰 값을 찾는다. 5이다. answer = "85"
0135 중 맨뒤 5를 제외하고 0,1,3 중에 가장 큰 값을 찾는다
 3 ==> answer = "853" 맨뒤 5를 붙이면 Answer = "8535"가 된다.
 */
public class 큰수만들기 {
    static boolean[] check;
    static long answer;
    public static void main(String[] args) {
        solution("1924", 2);
        solution("1231234", 3);
        solution("4177252841", 4);
    }
    static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        int compValue = 0;
        for(int i=0; i<number.length(); i++){
            compValue = 0;
            for(int j=idx; j<=i+k; j++){
                // 가장 더 큰값을 찾았으면 그값 기준으로 다음으로 넘어간다.
                if(compValue < number.charAt(j)-'0'){
                    compValue = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            answer.append(compValue);
        }
        return answer.toString();
    }
    /**
     * 시간초과 솔루션
     * @param number
     * @param k
     * @return
     */
    /*
    static String solution(String number, int k) {
        check = new boolean[number.length()];
        dfs(0,0,number,k,"");
        return Long.toString(answer);
    }

    private static void dfs(int cnt, int idx, String number, int k, String str) {
        if(cnt == number.length()-k){
            answer = Math.max(answer, Long.parseLong(str));
            return;
        }
        for(int i=idx; i<number.length(); i++){
            if(check[i]){
                continue;
            }
            check[i] = true;
            dfs(cnt+1, i, number,k,str+number.charAt(i));
            check[i] = false;
        }
    }

     */

}
