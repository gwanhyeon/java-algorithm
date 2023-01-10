package _2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	128 MB	137954	59889	37824	41.254%
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
대각선상에 집이 있는 경우는 연결된 것이 아니다.
<그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.



입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.

예제 입력 1
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
 */
public class boj_2667 {
    static int[][] map;
    static int[][] isVisited;
    static int answer;
    static int cnt;
    static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
    static int n;
    static List<Integer> arrList; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        isVisited = new int[n][n];
        arrList = new ArrayList<>();
        cnt = 0;
        answer = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for(int j=0; j<input.length(); j++){
                int target = Character.getNumericValue(input.charAt(j));
                map[i][j] = target;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isVisited[i][j] == 0 && map[i][j] == 1){
                    answer++;
                    cnt = 0;
                    bfs(i,j);
                }
            }
        }
        System.out.println(answer);
        Collections.sort(arrList);
        arrList.forEach(i -> System.out.println(i));
    }

    private static void bfs(int x, int y) {
        Queue<Graph> q = new LinkedList<>();
        q.add(new Graph(x,y));
        cnt++;
        isVisited[x][y] = cnt;
        while(!q.isEmpty()){
            Graph g = q.poll();
            int dx = g.x;
            int dy = g.y;
            for(int i=0; i<4; i++){
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];
                if(isRange(mx,my)){
                    continue;
                }
                if(isVisited[mx][my] == 0 && map[mx][my] == 1){
                    cnt++;
                    isVisited[mx][my] = cnt;
                    q.add(new Graph(mx,my));
                }
            }
        }
        arrList.add(cnt);
    }

    private static boolean isRange(int mx, int my) {
        if(mx < 0 || mx >= n || my < 0 || my >= n){
            return true;
        }
        return false;
    }

    private static class Graph {
        int x;
        int y;
        public Graph(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

