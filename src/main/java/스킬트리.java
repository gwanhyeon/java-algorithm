import java.util.ArrayList;

class 스킬트리 {
    public static void main(String[] args) {
        solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }
    static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<skill_trees.length; i++){
            int idx = 0;
            boolean tf = true;
            for(int j=0; j<skill_trees[i].length(); j++){
                if(idx < skill.indexOf(skill_trees[i].charAt(j))){
                    tf = false;
                    break;
                }else if(idx == skill.indexOf(skill_trees[i].charAt(j))){
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