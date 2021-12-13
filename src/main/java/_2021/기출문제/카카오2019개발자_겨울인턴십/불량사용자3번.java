package _2021.기출문제.카카오2019개발자_겨울인턴십;

import java.util.*;

/*

1. 풀이시간:25분
2.


return을 쓰지 않아서 무한루프에 빠졌다.. 실수를 줄이자
 */

/**
 * 1. 풀이시간 50분
 * 2. 컴퓨팅사고
 * 정규표현식을 이용하면 매우 쉽게 풀리는 문제이다. 해당 유저 값들에 대한 모든 경우의 수를 DFS 완전탐색을 통하여 가능한 모든 경우의 수를 구한다.
 * 모든 경우의 수 Basement조건은 제제아이디 목록의 개수까지 진행합니다. 정규표현식에서 "."은 어떤 문자 1개를 의미(어떤 값이든 가능하다)
 * 따라서, 하나의 예시 "*" -> 표현식을 -> "."으로 변경하면 fr*d* -> fr.d.x 처럼 변경이 됩니다.
 * 따라서 .으로 표현된 regex Match의 값을 유저의 아이디 값으로 경우의 수를 진행하게 되면 현재 제제 사용자인지 아닌지를 체크할 수 있게됩니다.
 * 해당 유저의 목록들을 하나의 셋의 목록으로 만들어주어 경우의 수가 몇개인지 체크할 수 있습니다.(중복되는 경우가 생길 수 있기때문에)
 *
 * 실수로 return을 안써주어서 로직이 잘못된줄 알고 괜히 시간을 날렸다.
 * 3. 시간복잡도 재귀함수..모든 조합의 경우 O(N^2)?
 */
public class 불량사용자3번{

    static boolean[] check;
    static HashSet<String> hs;
    public static void main(String[] args) {
        System.out.print(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "abc1**"}));
    }
    static int solution(String[] user_id, String[] banned_id) {
        check = new boolean[user_id.length];
        hs = new HashSet<>();
        dfs(user_id, banned_id, 0);
        return hs.size();
    }

    private static void dfs(String[] user_id, String[] banned_id, int idx) {

        // basement
        if(idx == banned_id.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<user_id.length; i++){
                if(check[i]){
                    sb.append(i);
                }
            }
            if(!hs.contains(sb.toString())){
                hs.add(sb.toString());
            }
            return;
        }

        for(int i=0; i<user_id.length; i++){
            if(check[i]){
                continue;
            }
            String rex = banned_id[idx].replace("*", ".");
            if(user_id[i].matches(rex)){
                check[i] = true;
                dfs(user_id, banned_id, idx+1);
                check[i] = false;
            }
        }
    }
}
