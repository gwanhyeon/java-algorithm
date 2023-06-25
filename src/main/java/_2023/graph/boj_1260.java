package _2023.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
DFS와 BFS 성공

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	218947	81862	48620	36.297%
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1
4 5 1
1 2
1 3
1 4
2 4
3 4
예제 출력 1
1 2 4 3
1 2 3 4
예제 입력 2
5 5 3
5 4
5 2
1 2
3 4
3 1
예제 출력 2
3 1 2 5 4
3 1 4 2 5
예제 입력 3
1000 1 1000
999 1000
예제 출력 3
1000 999
1000 999
 */
public class boj_1260 {
    static int n;
    static int m;
    static int v;
    static List<List<Integer>> arrList;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arrList = new ArrayList<>();
        isVisited = new boolean[n+1];
        for(int i=0; i<=n; i++){
            arrList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrList.get(x).add(y);
            arrList.get(y).add(x);
        }
        for(int i=0; i<=n; i++){
            Collections.sort(arrList.get(i));
        }
        dfs(v);
        Arrays.fill(isVisited, false);
        System.out.println();
        bfs(v);
    }
    static void dfs(int v){
        isVisited[v] = true;
        System.out.print(v + " ");
        for(int i=0; i<arrList.get(v).size(); i++){
            int target = arrList.get(v).get(i);
            if(!isVisited[target]){
                dfs(target);
            }
        }
    }
    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        isVisited[v] =true;

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int i=0; i<arrList.get(x).size(); i++){
                int y = arrList.get(x).get(i);
                if(!isVisited[y]){
                    isVisited[y] =true;
                    q.offer(y);
                }

            }
        }

    }

}

