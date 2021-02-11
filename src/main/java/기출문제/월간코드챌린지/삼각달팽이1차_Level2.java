package 기출문제.월간코드챌린지;
import java.util.ArrayList;


/**
 * https://yabmoons.tistory.com/575
 */
public class 삼각달팽이1차_Level2 {
    public static void main(String[] args) {


        solution(4);




    }
    static int[] solution(int n) {

        int[][] map = new int[n+1][n+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                map[i][j] = -1;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();

        int max_size = (n * (n+1)) / 2;
        int state = 0;
        int top = 1;
        int bottom = n;
        int left = 1;
        int right = 0;
        int num = 1;

        while(num <= max_size){

            if(state == 0){
                for(int i=top; i<=bottom; i++){
                    map[i][left] = num++;
                }
                top++;
                left++;
                state = 1;
            }else if(state == 1){

                for(int i=left; i<=bottom - right; i++){
                    map[bottom][i] = num++;
                }
                bottom--;
                state = 2;
            }else if(state == 2){

                for(int i=bottom; i >= top; i--){
                    map[i][i-right]=num++;
                }
                right++;
                top++;
                state = 0;
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j] != -1){
                    answer.add(map[i][j]);
                }
            }
        }
        answer.forEach(value -> System.out.println(value));

        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}
