package 월간코드챌린지;

import java.util.*;

/**
 * 해시맵으로 Object[] = hs.toArray()로 변환하면 55%에서 틀렸습니다 처리
 */
public class 두개뽑아서더하기1차_Level1 {
    static int[] check = new int[101];
    static HashSet hs = new HashSet();
    public static void main(String[] args) {
        solution(new int[]{1,1,1,1,1});
        //solution(new int[]{2,1,3,4,1});

    }
    static int[] solution(int[] numbers) {

        Arrays.sort(numbers);
        for(int i=0; i<numbers.length; i++){
            for(int j=i; j<numbers.length; j++){
                hs.add(numbers[i] + numbers[j]);
            }
        }
        /**
         * comment Iterator를 사용한 예제
         */
//        Iterator<Integer> it = hs.iterator();
//        ArrayList<Integer> answer = new ArrayList<>();
//        while(it.hasNext()){
//            answer.add(it.next());
//        }Collections.sort(answer);

        /**
         * comment 스트림을 사용한 예
         */
        ArrayList<Integer> answer = new ArrayList<>(hs);
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
        //return answer.stream().mapToInt(i -> i).toArray();
    }

    /**
     *
     * @param numbers 정수 배열
     * @param cnt 선택한 개수
     * @param sum 현재까지 더해진 값
     */
    private static void dfs(int[] numbers, int cnt, int sum) {

        if(cnt == 2){
            hs.add(sum);
            return;
        }

        for(int i=0; i<numbers.length; i++){
            if(check[i] == 1){
                continue;
            }
            check[i] = 1;
            dfs(numbers, cnt+1, sum+numbers[i]);
            check[i] = 0;
        }
    }
}

