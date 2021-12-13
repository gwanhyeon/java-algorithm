package _2021.스터디.스터디_GN.스터디_GN_3주차;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 실패율 {
    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }
    static int[] solution(int n, int[] stages) {
        List<Pair> arr = new ArrayList<Pair>();
        int stageCleared = 0;
        int stageArrived = 0;
        int[] answer = {};
        Arrays.sort(stages);
        // 1stage ~ N stage
        for(int i=1; i<=n; i++) {
            stageCleared = 0;
            stageArrived = 0;
            for (int j = 0; j < stages.length; j++) {
                // 스테이지 도달했지만 클리어하지 못한 플레이어 수
                if (stages[j] == i) {
                    stageCleared++;
                }
                // 스테이지에 도달한 플레이어수
                if (stages[j] >= i) {
                    stageArrived++;
                }
            }
            // 모두 스테이지에 도달한 경우 0으로 초기화
            if (stageCleared == 0) {
                arr.add(new Pair(0, i));
            }
            // 실패율 정렬하기 (스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수 / 스테이지에 도달한 플레이어수)
            else {
                arr.add(new Pair((double) stageCleared / stageArrived, i));
            }
        }
        Collections.sort(arr);          // 조건대로 정렬하기
        answer = new int[n];
        for(int i=0; i<arr.size(); i++){
            Pair p = arr.get(i);
            answer[i] = p.y; // 스테이지 번호 넣기
            System.out.println("stage=> " + p.y + " failed=>" + p.x);
        }
        return answer;
    }

    static class Pair implements Comparable<Pair>{
        double x;
        int y;
        Pair(double x, int y){
            this.x = x;
            this.y = y;
        }
        /*
         * A와 B가 같으면 0을 반환
         * A가 B보다 크면 양수를 반환
         * A가 B보다 작으면 음수를 반환
         */
        @Override
        public int compareTo(Pair pair) {
            // 실패율이 같으면 더 낮은 스테이지 올 수 있게한다.
            if(this.x == pair.x){
                // 오름차순
                if(this.y < pair.y){
                    return -1;
                }
                // 내림차순
                else {
                    return 1;
                }
            }else {
                // 실패율 내림차순 정렬
                return this.x < pair.x ? 1 : -1;
            }
        }
    }
}
