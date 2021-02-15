package 프로그래머스.Level2;

import java.util.*;

/**
 * 1. 잘못생각하였던점
 * hashmap을 그때그때 생각하여 값을 처리할 수 있었어야했다.결국 course는 몇개의 조합을 고를지에 대한 선택이였다.
 * 그리고 toCharArray를 사용하여 중복되는결과를 막아주었다. idx변수를 선언하여서 현재까지 진행된값에 대한 idx를 진행해야했는데 그부분을 간과했다. => 여기서틀렸다.
 * 문제에서 캐치를 못한 부분이 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴들을 코스요리 메뉴로 구성하기로 했습니다. 이것이 가장 중요한 부분이였다.
 * 괜히 주문을 몇번해서 course랑 맞는지 개뻘짓을 진행했다..문제를 못읽은거다.
 *
 */
public class 메뉴리뉴얼 {
    static int[] check = new int[21*11];
    static Map<String,Integer> m = new HashMap<>();
    static int max = 0;
    public static void main(String[] args) {
        solution(new String[]{"XYZ","XWY","WXA"}, new int[]{2,3,4});
        //solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
    }
    static List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for (int j = 0; j < course.length; j++) {
            m = new HashMap<>();
            for (int i = 0; i < orders.length; i++) {
                char[] charArray = orders[i].toCharArray();
                Arrays.sort(charArray);
                dfs(String.valueOf(charArray), course[j], 0,0, "");
            }
            for(String key : m.keySet()){
                if (max == m.get(key)) {
                    answer.add(key);
                }
                 System.out.println("key:" + key + " value:" + m.get(key));
            }
            max = 0;
        }
        Collections.sort(answer);
        for (String s1 : answer) {
            System.out.println(s1);
        }
        return answer;
    }

    private static void dfs(String order, int ans, int cnt, int idx,String str) {
        if(ans == cnt){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            if(m.containsKey(String.valueOf(charArray))){
                m.put(String.valueOf(charArray),m.get(String.valueOf(charArray))+1);
                max = Math.max(max, m.get(String.valueOf(charArray)));
            }else {
                m.put(String.valueOf(charArray),1);
            }
            return;
        }
        for(int i=idx; i<order.length(); i++){
            if(check[i] == 1){
                continue;
            }
            check[i] = 1;
            // idx처리를 안해서 틀렸다. 조심하자!!!!!!
            dfs(order, ans, cnt+1,i+1,str+order.charAt(i));
            check[i] = 0;
        }
    }
}
