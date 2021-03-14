package 스터디.스터디_GN.스터디_GN_10주차;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public static void main(String[] args) {
//        solution(new int[]{93,30,55},new int[]{1,30,5});
        solution(new int[]{95,90,99,99,80,99},new int[]{1,1,1,1,1,1});
    }
    // 96 91 100 100 81 100
    // 97 ~
    // 100 95 104 104
    static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int idx = 0; // 배포 기준
        int cnt = 0; // 한번에 배포되는 수
        while(idx < progresses.length){
            // 하루마다 진도율 처리
            for(int i=0; i<progresses.length; i++){
                progresses[i] += speeds[i];
            }
            // 작업 배포
            if(progresses[idx] >= 100){
                // 다른작업도 배포 처리가능 여부
                while(idx < progresses.length && progresses[idx] >= 100){
                    cnt++;
                    idx++;
                }
                answer.add(cnt);
                cnt=0;
            }
        }
        int[] res = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            res[i] = answer.get(i);
        }
        return res;
    }
}
