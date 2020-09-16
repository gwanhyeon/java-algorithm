import java.util.ArrayList;
import java.util.List;
public class 모의고사 {


    public static void main(String[] args) {

        List<Integer> winner = new ArrayList<>();

        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] students = {0,0,0};
        int[] answers = {1,2,3,4,5};
        int[] answer = {}; // 출력값

        for(int i=0; i<answers.length; i++){
            if(student1[i % student1.length] == answers[i]){
                students[0]++;
            }
            if(student2[i%student2.length] == answers[i]){
                students[1]++;
            }
            if(student3[i%student3.length] == answers[i]){
                students[2]++;
            }
        }

        int win = students[0];
        // 가장높은 점수를 받은 사람 찾기
        for(int i=0; i<students.length; i++){
            if(win < students[i]){
                win = students[i];
            }
        }
        // 같은 값을 가진 여럿사람일 경우도 있기때문에 확인을 해서 넣어줍니다.
        for(int i=0; i<students.length; i++){
            if(win == students[i]){
                winner.add(i);
            }
        }
        answer = new int [winner.size()];
        // 가장 높은 점수를 가진사람의 값을 answer에 담아줍니다.
        for (int i=0; i<winner.size();i++){
            answer[i]=winner.get(i)+1;
        }
    }

}
