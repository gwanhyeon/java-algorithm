package _2021.개인문제풀이;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class 영어끝말잇기 {


    public static void main(String[] args) {
        solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }
    static void solution(int n, String[] words) {
        int[] answer = {0, 0};
        Set<String> s = new HashSet<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Pair> arr = new ArrayList<>();

        String prev = "";
        s.add(words[0]);
        for(int i=1; i<words.length; i++){

            // set에 포함 되어 있지 않거나 last 단어와 first단어가 같지 않을 경우 종료
            if(s.contains(words[i]) || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i % n) + 1;            // 몇번쨰 사람인지 (i % n) + 1
                answer[1] = (i / n) + 1;            // 해당 사람의 몇번쨰 순서 인지 (i / n) + 1
                break;
            }else {
                s.add(words[i]);
            }
        }
        System.out.println(answer[0] + "" + answer[1]);
    }
}