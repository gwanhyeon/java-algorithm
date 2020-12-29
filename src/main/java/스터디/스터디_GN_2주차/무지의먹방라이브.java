package 스터디.스터디_GN_2주차;


/**
 * 1. 소요시간: 약 40분
 * 2. 컴퓨팅사고
 * 무지의 먹방라이브를 진행하는데 방송을 진행하고도 먹고있는 음식의 번호를 맞추는 문제이다.
 * 총 무지의 먹방 시간이 몇 초가 진행되었는지 체크하는 변수 cnt
 * 무지가 먹을수 없는 음식이 몇개인지 체크하는 변수 zeroCnt, 만약 zeroCnt가 food길이랑 같다면 지금 먹을 수 있는 음식은 하나도 없는 것이 되기때문에 -1을 반환시켜준다.
 * 방송장애가 일어나는 시점에 현재 i+1을 반환하면 현재 무지가 다음에 먹으려고 하는 먹방의 번호가 되기 때문에 그상태로 빠져나온다.
 * 무지가 1초가 지날때마다 음식을 하나씩 헤치울수 있기때문에 food_times[i]--를 하나씩 줄여주었다.
 * 그리고, 다른 테스트케이스중에서 {1,1,1,1}, 4 의 경우에는 1을 헤치우고나면 모두 {0,0,0,0}이 되기 때문에 푸드시간을 감소시키고 나서도 다시 zeroCnt값을 체크하여주었다.
 * 리팩토링시 처음에 While문안에 for문을 돌리는 형식으로 진행되었는데 시간복잡도상 여러 오류가 생길 수 있다고 판단하여 while문을 없애고 i값이 food_time에 도달하였을때
 * i값을 -1, zeroCnt 0 으로 초기화해주었다. i값을 -1로 해준이유는 for문을 진행할시에 마지막 포문을 빠져나오고 나면 결국 1값이 증가되기 때문에 -1로 해주어야지 0의 값으로
 * 재순환시켜줄 수 있도록 하였다.
 * 현재 이 풀이는 정확도는 모두 맞는 문제이지만, 효율성에서 모두 시간초과가 나는 풀이이다. 복잡도를 낮추기 위해서 계속 확인중에 있지만 어떻게 더 줄일 수 있을지에 대한 고민이 필요해보인다.
 * 시간복잡도
 * 현재 효율성의 시간복잡도는
 * food_times 의 길이는 1 이상 200,000 이하이다.
 * food_times 의 원소는 1 이상 100,000,000 이하의 자연수이다.
 * k는 1 이상 2 x 10^13 이하의 자연수이다.
 * 와 같기때문에 아마 k의 범위에서 시간초과가 나지않나 생각하고 있다. 왜냐하면 food_times로는 충분히 O(N)만큼으로 순회할 수 있다고 판단하였기 때문이다.
 */
public class 무지의먹방라이브 {
    public static void main(String[] args) {
//        solution(new int[]{3,1,2}, 5);  // 1
//        solution(new int[]{4,2,3,6,7,1,5,8},16); // 3
//        solution(new int[]{4,2,3,6,7,1,5,8},27);  // 5
//        solution(new int[]{1,5,5,5,5,6,7},31);  // 6
//        solution(new int[]{1,1,1,1},4);  // -1
//        solution(new int[]{4,3,5,6,2},7); // 3
//        //예외 케이스 답 6
//        solution(new int[]{3,1,1,1,2,4,3},12);  // 6


        solution1(new int[]{3,1,2}, 5);
        solution1(new int[]{4,2,3,6,7,1,5,8},16);
        solution1(new int[]{4,2,3,6,7,1,5,8},27);
        solution1(new int[]{1,5,5,5,5,6,7},31);
        solution1(new int[]{1,1,1,1},4);
        solution1(new int[]{4,3,5,6,2},7);

        // 예외 케이스 답 6
        solution1(new int[]{3,1,1,1,2,4,3},12);

    }
    static int solution(int[] food_times, long k) {
        // 무지먹방 시간을 체크 하는 변
        int cnt = 0;
        // 무지 먹방 방송사고 체크
        boolean isFaild = false;
        // 0의 개수체크로 빠져나온다.
        int zeroCnt = 0;
        // 무지 먹방 순서
        int answer = 0;

        // 계속 진행되어야 하므로 while
        while(true){
            if(isFaild){
                break;
            }
            // 음식의 개수 만큼 진행
            for(int i=0; i<food_times.length; i++){


                if(cnt > k){
                    break;
                }

                if(food_times[i] == 0){
                    zeroCnt++;
                    continue;
                }else {
                    // 방송장애가 일어나는 시점
                    if(cnt == k){
                        isFaild = true;
                        answer = i+1;
                        break;           // 해당되는 시점에서 복구후에 다시먹어야하므로
                    }
                    // 무지먹방의 시간을 체크한다.
                    cnt++;
                    // 음식의 개수를 줄여준다.
                    food_times[i]--;

                    if(food_times[i]==0){
                        zeroCnt++;
                    }
                }
            }
            // 0의 개수가 푸드시간과 같다는것은 더이상진행할 값이 없다는것이고 방송사고까지 일어난 상태이면 종료
            if(zeroCnt == food_times.length){
                answer = -1;
                break;
            }
            // zero의 개수를 초기
            zeroCnt = 0;
        }
        System.out.println(answer);
        return 1;
    }

    /**
     * 시간초과를 해결해보
     * @param food_times
     * @param k
     * @return
     */
    static int solution1(int[] food_times, long k) {

        // 무지먹방 시간을 체크 하는 변
        int cnt = 0;
        // 무지 먹방 방송사고 체크
        boolean isFaild = false;
        // 0의 개수체크로 빠져나온다.
        int zeroCnt = 0;
        int oneCnt = 0;
        // 무지 먹방 순서
        int answer = 0;


        // 음식의 개수 만큼 진행
        for(int i=0; i<food_times.length; i++){

            if(food_times[i] == 0 ){
                zeroCnt++;
            }else {
                // 방송장애가 일어나는 시점
                if(cnt == k){
                    answer = i+1;
                    break;           // 해당되는 시점에서 복구후에 다시먹어야하므로
                }
                // 무지먹방의 시간을 체크한다.
                cnt++;
                // 음식의 개수를 줄여준다.
                food_times[i]--;
                if(food_times[i] == 0){
                    zeroCnt++;
                }
            }
            // 0의 개수가 푸드시간과 같다는것은 더이상진행할 값이 없다는것이고 방송사고까지 일어난 상태이면 종료
            if(zeroCnt == food_times.length){
                answer = -1;
                break;
            }
            if(i == food_times.length-1){
                zeroCnt = 0;
                i = -1;
            }
        }
        // zero의 개수를 초기
        System.out.println(answer);
        return 1;
    }


}
