package 카카오2019개발자_겨울인턴십;

import java.util.*;

/*

풀이시간:25분
return을 쓰지 않아서 무한루프에 빠졌다.. 실수를 줄이자
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
