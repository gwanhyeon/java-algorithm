import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class 실패율 {
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
        public int compareTo(Pair arr2) {
            if(x == arr2.x)
            {
                if(y < arr2.y)
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }
            else if(x > arr2.x)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[] stages ={2, 1, 2, 6, 2, 4, 3, 3};

        List<Pair> arr = new ArrayList<Pair>();

        int stage_clear = 0;
        int stage_arrive = 0;
        int[] answer = {};
        Arrays.sort(stages);
        // 1stage ~ N stage
        for(int i=1; i<=n; i++) {
            stage_clear = 0;
            stage_arrive = 0;
            for (int j = 0; j < stages.length; j++) {

                // 스테이지 도달했지만 클리어하지 못한 플레이어 수
                if (stages[j] == i) {
                    stage_clear++;
                }
                // 스테이지에 도달한 플레이어수
                if (stages[j] >= i) {
                    stage_arrive++;
                }

            }
            if (stage_clear == 0) {
                arr.add(new Pair(0, i));
            } else {
                arr.add(new Pair((double) stage_clear / stage_arrive, i));
            }
        }
        Collections.sort(arr);
        //Arrays.sort(arr, Comparator.reverseOrder());
        //Arrays.sort(arr,rever);


//        Arrays.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer i1, Integer i2) {
//                return i2 - i1;
//            }
//        });
        answer = new int[n];

        for(int i=0; i<arr.size(); i++){
            Pair p = arr.get(i);
            answer[i] = arr.get(i).y; // 스테이지 번호 넣기
            System.out.println(answer[i]);
        }
    }
}

/*
패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 */