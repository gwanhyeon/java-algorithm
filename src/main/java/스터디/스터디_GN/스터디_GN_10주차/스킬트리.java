package 스터디.스터디_GN.스터디_GN_10주차;

/**
 * 1. 풀이시간: 5분
 * 2. 컴퓨팅사고
 * 스킬트리를 배우기 위해서는 선행스킬이 밑받침이 되어야합니다.
 * 따라서, 선행스킬의 idx값과 현재진행하는 currIdx값을 비교하면서
 * idx == currIdx가 같다면 idx++값을 더해나가면서 계쏙진행하고
 * 만약 currIdx > idx보다 크다면 올바르지않은 순서로 스킬을 배운것이므로 처리할 수 없습니다.
 * 따라서, boolean 변수를 하나선언한 후에 boolean 값이 false인 경우에만 answer++값을 추가시켜주었습니다.
 */
public class 스킬트리 {
    public static void main(String[] args) {
        solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});

    }
    static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++){
            int idx = 0;
            boolean tf = false;
            for(int j=0; j<skill_trees[i].length(); j++){
                int currIdx = skill.indexOf(skill_trees[i].charAt(j));
                if(currIdx > idx){
                    tf = true;
                    break;
                }else if(currIdx == idx){
                    idx++;
                }
            }
            if(tf){
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
