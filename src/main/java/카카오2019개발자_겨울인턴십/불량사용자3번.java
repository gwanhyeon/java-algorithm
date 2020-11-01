package 카카오2019개발자_겨울인턴십;

import java.util.*;


public class 불량사용자3번{
    static int user_len;
    static int banned_len;
    static Set<String> s;
    static boolean[] check;
    static int answer = 0;
    public static void main(String[] args) {
        int ans = solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}
        , new String[]{"fr*d*", "abc1**"});
        System.out.println(ans);
    }
    public static int solution (String[]user_id, String[]banned_id){
        user_len = user_id.length;
        banned_len = banned_id.length;
        s = new HashSet<>();
        check = new boolean[user_len];

        dfs(user_id, banned_id, "", 0);
        return s.size();
    }
    static void dfs (String[]user_id, String[]banned_id, String str,int idx){

        if (idx == banned_len) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < user_len; i++) {
                if (check[i] == true) {
                    sb.append(user_id[i]);
                }
            }

            if (!s.contains(sb.toString())) {
                s.add(sb.toString());
            }

            return;
        }

        for (int i = 0; i < user_len; i++) {
            if (check[i] == true) {
                continue;
            }
            // 정규표현식 매칭
            String rex = banned_id[idx].replace("*", ".");
            if (user_id[i].matches(rex)) {
                check[i] = true;
                dfs(user_id, banned_id, str + i, idx + 1);
                check[i] = false;
            }
        }
    }


}


/* 오답 문제
public class 불량사용자3번 {
    static Set<String> s;
    static HashMap<String,String> hm;
    static HashMap<String,String> answer_hm;
    static int check[];
    static int answer;


    public static void main(String[] args) {


        //String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        //String[] banned_id = {"fr*d*", "abc1**"};
        hm = new HashMap<>();
        answer_hm = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        s = new HashSet<>();
        for(int k=0; k<banned_id.length; k++){
            String tmp = banned_id[k].replaceAll("[*]", "");
            for(int i=0; i<user_id.length; i++){
                int cnt = 0;
                for(int j=0; j<user_id[i].length(); j++){
                    // 문자길이가 같을 경우 한글자씩 비교하기 위함
                    if(user_id[i].length() == banned_id[k].length()){
                        //
                        if(user_id[i].charAt(j) == banned_id[k].charAt(j)){
                            cnt +=1;
                        }
                    }
                }
                if(tmp.length() == cnt){
                    arr.add(user_id[i]);
                    hm.put(user_id[i],banned_id[k]);
                    s.add(banned_id[k]);
                }
            }
        }


        int i = 0;
        check = new int[s.size()];
        dfs(0,0);
        System.out.println(answer_hm.size());


    }

    private static void dfs(int idx,int cnt) {
        if(cnt == s.size()){
            Set set = hm.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry)iterator.next();
                String key = (String)entry.getKey();
                String value = (String)entry.getValue();
                Set set1 = hm.entrySet();
                Iterator iterator1 = set1.iterator();

                while(iterator1.hasNext()){
                    Map.Entry entry1 = (Map.Entry)iterator1.next();
                    String key1 = (String)entry1.getKey();
                    String value1 = (String)entry1.getValue();
                    //if(!value.equals(value1)){
                        answer++;
                        if(!answer_hm.containsValue(value) || !answer_hm.containsValue(value1))
                            answer_hm.put(value,value1);
                        //System.out.println("value" + value + "value1" + value1);
                    //    break;
                    //}
                }
            }
        }
        for(int i=idx; i<s.size(); i++) {
            if (check[i] == 1) {
                continue;
            }
            check[i] = 1;
            dfs(i, cnt + 1);
            check[i] = 0;

        }
    }
}*/
