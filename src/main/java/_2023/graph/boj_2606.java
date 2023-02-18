package _2023.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
boj_2606
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	120116	57801	38881	46.162%
문제
신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다. 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.



어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

출력
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

예제 입력 1
7
6
1 2
2 3
1 5
5 2
5 6
4 7
예제 출력 1
4
 */

//dfs

public class boj_2606 {

    static List<List<Integer>> graphList;
    static boolean[] isVisited;
    static int n;
    static int m;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graphList = new ArrayList<>();
        isVisited = new boolean[n+1];
        answer = 0;
        for(int i=0; i<n+1; i++){
            graphList.add(new ArrayList<>());
        }
        StringTokenizer st;

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graphList.get(x).add(y);
            graphList.get(y).add(x);
        }
        dfs(1);
        System.out.println(answer);
    }
    private static void dfs(int x){
        isVisited[x] = true;
        for(int i=0; i<graphList.get(x).size(); i++){
            int y = graphList.get(x).get(i);
            if(!isVisited[y]){
                isVisited[y] = true;
                dfs(y);
                answer++;
            }
        }
    }
}


// bfs
/*public class boj_2606 {
    static int computerSize = 0;
    static int computerEdgeSize = 0;
    static List<List<Integer>> arrList;
    static int[] virus;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computerSize = Integer.parseInt(br.readLine());
        computerEdgeSize = Integer.parseInt(br.readLine());
        StringTokenizer st;
        virus = new int[computerSize+1];
        answer = 0;
        arrList = new ArrayList<>();
        for(int i=0; i<=computerSize; i++){
            arrList.add(new ArrayList<>());
        }

        for(int i=0; i<computerEdgeSize; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arrList.get(x).add(y);
            arrList.get(y).add(x);
        }
        bfs(1);
        System.out.println(answer);
    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        virus[x] = 1;
        q.add(x);
        while(!q.isEmpty()){
            int dx = q.poll();
            for(int i=0; i<arrList.get(dx).size(); i++){
                int mx = arrList.get(dx).get(i);
                if(virus[mx] == 0){
                    answer++;
                    virus[mx] = virus[dx] + 1;
                    q.add(mx);
                }
            }
        }

    }
}*/
