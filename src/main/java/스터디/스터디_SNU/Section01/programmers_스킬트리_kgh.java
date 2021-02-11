package 스터디.스터디_SNU.Section01;
// comment: 1주차 알고리즘 Programmers 스킬트리 문제
// comment: https://programmers.co.kr/learn/courses/30/lessons/49993

/*
풀이시간: 18분 16초
선행스킬을 배우기위해서는 현재 진행하는 id값과 같아야하기때문에
indexOf로 현재 진행하는 인덱스와 같은지여부를 찾아냅니다 만약에 찾은인덱스가 더 클 경우
올바르지 값을 break해주어야합니다.

*/
public class programmers_스킬트리_kgh {
    public static void main(String[] args) {
        solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }
    static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++){
            int idx = 0;
            boolean tf = false;
            for(int j=0; j<skill_trees[i].length(); j++){
                int search = skill.indexOf(skill_trees[i].charAt(j));
                if(idx < search){
                    tf = true;
                    break;
                }else if(idx == search){
                    idx++;
                }
            }
            if(tf == false){
                answer++;
            }
        }
        return answer;
    }
}
