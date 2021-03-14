package 스터디.스터디_GN.스터디_GN_1주차;

// comment 복습 201227
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 1.
 * 2.
 * 풀이방식1 : 공포도 배열값을 오름차순 정렬을 시켜줍니다. 값들을 비교해나가면서 같은값을 가지고 있으면 tmp리스트변수에 담아놓습니다. 그리고 그룹에 대한 카운팅값을 +1 해주면서
 * 현재 arr값을 clear한후 tmp값으로 다시 재진행합니다. 그러다가 하나의 카운트변수를 두어서 모두 같은값의 개수와 현재 리스트의 개수-1과 같다면 더 이상 돌 필요가 없으므로 종료시켜줍니다.
 *
 * 풀이방식2 : 그리디 알고리즘을 사용하여 최적의해를 구하기 위해서는 오름차순정렬로 가장낮은 공포도부터 시작하여 최소한의 인원으로 결성된 그룹의 개수를 구해야합니다.
 * case 1) 2,3,1,2,2의 공포도가 주어졌을때 [1,2,3], [2,2] 의 총 2개의 그룹은 생성시킬 수 있습니다. 하지만, 조건에 모든 모험가는 특정한 그룹에 넣을필요가 없다는 조건이 있기때문에
 * 최적의 조건이 아닙니다. 즉, 공포도를 하나씩 확인하면서 현재 그룹에 포함된 모험가의 수가 현재확인하고 있는 공포도 보다 크다면 이를 그룹으로 설정하면 됩니다.
 *
 * case 2) 1,2,2,2,3 의 경우를 살펴보면 1명부터 모험가의 개수가 시작되기 때문에 1로 시작하여 모험가의 수가 현재의 공포도 이상이라면 그룹을 결성시킵니다.
 * 모험가수 1, 공포도 1 -> 모험가수가 공포도 이상이기 때문에 그룹 결성 -> 그룹1 [1]
 * 모험가수 1, 공포도 2 -> 모험가수가 공포도 이상이 아니기 때문에 다음 모험가를 포함시킵니다. -> 그룹2[2]
 * 모험가수 2, 공포도 2 -> 모험가수가 공포도 이상이기 때문에 그룹 결성 -> 그룹2[2,2]
 * 모험가수 1, 공포도 2 -> 모험가수가 공포도 이상이 아니기 때문에 다음 모험가를 포함시킵니다. -> 그룹 X
 * 모험가수 2, 공포도 3 -> 모험가수가 공포도 이상이 아니기 때문에 다음 모험가를 포함시킵니다.(마지막의 경우이므로 종료) -> 그룹 X
 * 따라서, 그룹1[1], 그룹2[2,2] 의 경우로 그룹을 결성한 것을 확인할 수 있습니다.
 * 즉, 공포도가 X인 모험가는 반드시 X이상인원으로 구성한 모험가 그룹에 참여할 수 있으므로 count 변수를 만들어서 참여자의 수를 카운팅하면서
 * 공포도 <= 참여한 인원의 개수가 되었을 때 그룹으로 결성할 수 있습니다. 그룹으로 결성하고 나서는 현재 참여하였던 인원들은 초기화 시킬 필요가 있으므로 다시 카운팅 변수를 초기화시켜주게됩니다.
 * 시간복잡도: N <= 100,000의 범위이므로 최대 O(NlogN)까지 처리할 수 있음을 의미합니다. 해당 풀이는 O(N=리스트의사이즈) 만큼의 시간복잡도를 띄게 됩니다.
 */
public class 모험가길드_그리디 {
    public static void main(String[] args) {
//        System.out.println("List 풀이");
//        solution(5, new int[]{2,3,1,2,2});
//        solution(5, new int[]{1,2,3,4,5});
//        solution(5, new int[]{1,2,2,3,4,5});
        System.out.println("Greedy 풀이");
        solution1(5, new int[]{2,3,1,2,2});
        solution1(5, new int[]{1,2,3,4,5});
        solution1(5, new int[]{1,2,2,3,4,5});
    }
    private static void solution1(int n, int[] arr) {
        ArrayList<Integer> fearList = Arrays.stream(arr)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
        int participantGroup = 0;
        int participantCnt = 0;
        for (int i = 0; i < fearList.size(); i++) {
            participantCnt++;
            if(participantCnt >= fearList.get(i)){
                participantGroup +=1;
                participantCnt = 0;
            }
        }
        System.out.println(participantGroup);
    }

    private static void solution(int n, int[] arr) {
        ArrayList<Integer> fearList = Arrays.stream(arr)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        int answer = 0;
        while(fearList.size() > 0){
            ArrayList<Integer> tmpList = new ArrayList<>();
            int cnt = 0;
            for(int i=0; i<fearList.size()-1; i++){
                // 값이 더 클 경우
                if(fearList.get(i) < fearList.get(i+1)){
                    continue;
                }else {
                    tmpList.add(fearList.get(i+1));
                    cnt++;
                }
            }
            answer++;
            if(cnt == fearList.size()-1){
                break;
            }
            fearList.clear();
            fearList.addAll(tmpList);
        }
        System.out.println(answer);
    }
}
