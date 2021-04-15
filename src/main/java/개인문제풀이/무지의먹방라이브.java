

public class 무지의먹방라이브 {
    public static void main(String[] args) {

        int[] food_times = {1,1,1};
        int k = 5;


        // 만약더 섭취할 음식이 없으면 -1

        // 방송이 중단된 시간 k

        //food_times은 각음 식을 모두 먹는데 필요한 시간이 음식의번호 순서대로 들어있는 배열이다.



        int time = 0;     // 현재 몇번 음식을 섭취해야하는지
        int target = 0;
        int answer = 0;
        Boolean flag = false;

        int empty_size = 0;
        for(int i=0; i<food_times.length; i++){




            // 음식이 0 이면 패쓰
            if(food_times[i] == 0){
                empty_size++;
                if(empty_size == food_times.length){
                    answer = -1;
                    break;
                }
                continue;
            }else {

                food_times[i] = food_times[i]-1;
                time++;
                target = i-1;
                if(time == k){
                    answer = target;
                    break;
                }
            }

            // 끝지점에 도달했을때 다시 0번째 접시부터 확인한다.
            if(i == food_times.length-1){
                i = -1;
            }
        }

        System.out.println(answer);


    }
}
