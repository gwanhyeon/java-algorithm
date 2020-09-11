import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class 실패율 {
    class Pair{

        Pair(Double x, Integer y){

        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[] stages ={2, 1, 2, 6, 2, 4, 3, 3};

        ArrayList<Double, Integer> arr = new ArrayList<Double,Integer>();

        int stage_clear = 0;
        int stage_arrive = 0;
        int[] answer = new int[stages.length];
        Arrays.sort(stages);
        // 1stage ~ N stage
        for(int i=1; i<=n; i++){
            stage_clear = 0;
            stage_arrive = 0;
            for(int j=i-1; j<stages.length; j++){

                // 스테이지 도달했지만 클리어하지 못한 플레이어 수
                if(stages[j] == i){
                    stage_clear++;
                }
                // 스테이지에 도달한 플레이어수
                if (stages[j] >= i){
                    stage_arrive++;
                }

            }
            answer[i-1] = stage_clear / stage_arrive;
        }
    }
}

/*
실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 */