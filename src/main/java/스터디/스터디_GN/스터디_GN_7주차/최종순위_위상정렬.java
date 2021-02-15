package 스터디.스터디_GN.스터디_GN_7주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
3
5
5 4 3 2 1
2
2 4
3 4
3
2 3 1
0
4
1 2 3 4
3
1 2
3 4
2 3
 */

/**
 * 문제 해결 방법
 * 1. 정해진 우선순위에 맞게 전체팀들의 순서를 나열해야한다 -> 우선순위를 가지고 탐색을 진행해야하므로 위상정렬알고리즘을 떠올릴 수 있어야한다.
 * 2. 작년순위(우선순위가) 주어지기때문에 해당 정보를 가지고 방향그래프 생성
 * 3. 만약 상대적인 우선순위가 바뀌게된다면 해당간선의 방향을 반대로 만들고, 0으로 초기화 시켜줍니다.
 * 또한, 간선의 개수도 증가,감소를 통하여 해당 반대로된 순위의 간선을 해제시키고 추가해준다.
 *
 * 4. 위상정렬은 고려해야할점은 2가지
 * (1) 사이클생성 X, 위성정렬의 결과가 1개가 아니라 여러가지인 경우 위상정렬이 될 수 없음.
 * 위상정렬을 수행한 결과는 단 1개의 정렬걸과가 나와야한다.
 *
 */
public class 최종순위_위상정렬 {
    // 간선의 개수 저장
    static int[] indegree = new int[501];
    static int[][] graph = new int[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0){
            Arrays.fill(indegree,0);
            for(int i=0; i<501; i++){
                Arrays.fill(graph[i],0);
            }
            int n = Integer.parseInt(br.readLine());

            List<Integer> arrList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 작년 순위 정보 입력
            while(st.hasMoreTokens()){
                arrList.add(Integer.parseInt(st.nextToken()));
            }
            // 방향그래프의 간선 정보 초기화
            for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    graph[arrList.get(i)][arrList.get(j)] = 1;      // 연결된 모든 간선을 1
                    indegree[arrList.get(j)] +=1;       // 방향그래프이므로 a->b
                }
            }
            int m = Integer.parseInt(br.readLine());
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                // 간선의 방향 뒤집기
                if(graph[x][y] == 1){
                    graph[x][y] = 0;        // 간선 미체크
                    graph[y][x] = 1;        // 간선 체크
                    indegree[x] += 1;       // 간선의 개수 증가
                    indegree[y] -= 1;       // 간선의 개수 감소
                }else {
                    graph[x][y] = 1;
                    graph[y][x] = 0;
                    indegree[x] -= 1;
                    indegree[y] += 1;
                }
            }
            // 위상정렬
            List<Integer> answer = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            // 처음시작할때 진입차수가 0인 노드를 큐에 삽입합니다.
            for(int i=1; i<=arrList.size(); i++){
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
            // 위성정렬결과 하나인지 체크
            boolean isCheckTopology = true;
            // 그래프내 사이클이 존재하는지 여부 체크
            boolean isCycle = false;
            for(int i=0; i<n; i++){
                if(q.size() == 0){
                    isCycle = true;
                    break;
                }
                // 큐사이즈가 2이상인경우 정렬 결과 여러개
                if(q.size() >= 2){
                    isCheckTopology = false;
                    break;
                }
                // 큐에서 원소 꺼내기
                int curr = q.poll();
                answer.add(curr);
                // 연결된 노드들의 진입차수 1빼기
                for(int j=1; j<=n; j++) {
                    if (graph[curr][j] == 1) {
                        indegree[j] -= 1;
                        // 새롭게 진입차수가 0이 되는 노드를 큐에 삽입
                        if (indegree[j] == 0) {
                            q.offer(j);
                        }
                    }
                }
            }
            // 사이클이 발생하는 경우 X
            if(isCycle){
                System.out.println
                        ("IMPOSSIBLE");
            }
            // 위상 정렬 결과가 여러개 인 경우
            else if(!isCheckTopology){
                System.out.println("?");
            }
            // 위상 정렬을 수행한 결과 출력
            else {
                for(int i=0; i<answer.size(); i++){
                    System.out.print(answer.get(i)+ " ");
                }
                System.out.println();
            }
        }
    }
}
