package _2021.기출문제.카카오인턴십2020;

import java.util.*;
/* 투포인트 알고리즘 */

public class 보석쇼핑3번 {
    static Queue<String> q = new LinkedList<>();
    static HashSet<String> hs = new HashSet<>();
    static HashMap<String, Integer> hm = new HashMap<String,Integer>();
    static int startPoint = 0;
    static int len = Integer.MAX_VALUE;

    /**
     *  * https://blog.naver.com/kks227/220795165570
     *  * https://programmers.co.kr/questions/11940료
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
    }
    static int[] solution(String[] gems) {
        int[] answer = new int[2];


        for(String s : gems){
            hs.add(s);
        }

        int start = 0;
        for(int i=0; i<gems.length; i++){

            if(!hm.containsKey(gems[i])){
                hm.put(gems[i], 1);
            }else {
                hm.put(gems[i],hm.get(gems[i])+1);
            }
            q.add(gems[i]);

            while(true){

                String temp = q.peek();
                if(hm.get(temp) > 1){
                    hm.put(temp, hm.get(temp)-1);
                    q.poll();
                    startPoint++;
                }else {
                    break;
                }
            }
            if(hm.size() == hs.size() && len > q.size()){
                len = q.size();
                start = startPoint;
            }
        }
        //System.out.println(start+1 + "" + start+len);



        answer[0] = start + 1;
        answer[1] = start + len;

        for(int i : answer){
            System.out.println(i);
        }

        return answer;
    }
}
