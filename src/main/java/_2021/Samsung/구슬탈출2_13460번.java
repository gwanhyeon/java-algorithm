package _2021.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://ghkvud2.tistory.com/40 참고 블로그


/*
시뮬레이션 과정
1. BFS와 하나의 클래스를 선언합니다.
2. 클래스에는 구슬들의 X,Y 좌표와 현재까지 몇번 기울였는지를 담고 있는 변수값을 가지고 있습니다.(redRow, redCol, blueRow, blueCol, actionsSIze)
3. 현재 방문한 위치를 확인하기 위하여 isChecked 4차원 변수를 선언하여 각각의 위치에 대해서 값을 가지고 있습니다. 최대 3 <= n,m <= 10의 범위 이므로 [10][10][10][10]의 범위 값을 가지고 있습니다.
4. 빨간 구슬과 파란구슬의 위치를 저장시켜 놓습니다.
5. BFS를 수행합니다.
    1. 구슬을 굴리는데 두개의 구슬의 겹쳐지는 경우는 생각하지 않고 일단 모두 굴립니다. ‘#’에 부딪히지 않을때까지 굴립니다.(빨간구슬 ,파란구슬 모두)
    2. 구슬을 굴리는 도중에 ‘O’를 만나서 빠져나가게 된다면 멈추고 다른 방향으로 다시 진행합니다. continue
6. 구슬을 다 굴린후에 처리를 진행합니다.
    1. 파란색 구슬이 ‘O’에 빠진지 확인합니다.
    2. 파란색 구슬이 ‘O’에 빠지면 탐색을 종료합니다. 즉, 다른 방향으로 탐색을 계속 진행하는것과 같습니다.
    3. 파란색 구슬이 ‘O’에 빠지지 않고 빨간구슬이 ‘O’에 빠지면 탐색을 종료하고 현재 action size+1의 값을 반환시켜 줍니다.
    4. 같은 위치에 있다면 값을 조정합니다. 예를 들어, 오른쪽으로 기울었다고 가정하면 빨간색위치가 파란색위치보다 앞서있으면 파란색의 위치를 왼쪽으로 x,y-1의 값으로 조정시켜줍니다. 반대로 빨간구슬의 경우도 마찬가지로 값의 위치를 변경시켜서 진행합니다.
7. 모든 구슬의 위치를 갱신시킨후 isCheckd 변수에 있는 값이 방문하지 않은 위치라면 다음 queue에 해당 값들을 넘겨주면서 해당 위치에서 부터 다시 재 진행을 합니다.
 */

public class 구슬탈출2_13460번 { 
    static char[][] map;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}}; // 동서남북
    static boolean[][][][] isChecked;
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        isChecked = new boolean[10][10][10][10];
        map = new char[n][m];
        Node node = new Node();
        node.actionsSize = 0;

        //1. 구슬 맵 입력
        for(int i=0; i<n; i++) {
            String row = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = row.charAt(j);
                if(map[i][j] =='R'){
                    node.redRow = i;
                    node.redCol = j;
                }else if(map[i][j] == 'B'){
                    node.blueRow = i;
                    node.blueCol = j;
                }
            }
        }
        bfs(node);
        print();
    }

    private static void print() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void bfs(Node marble) {
        Queue<Node> q = new LinkedList<>();
        isChecked[marble.redRow][marble.redCol][marble.blueRow][marble.blueCol]= true;
        q.add(marble);
        
        while(!q.isEmpty()){
            Node node = q.poll();
            // 10회 이하 초과시 -1
            if(node.actionsSize >= 10){
                System.out.println(-1);
                return;
            }
            // 동서남북기준으로 구슬을 굴린다.
            for(int k=0; k<4; k++){
                // 파란색 구슬 굴리기
                int blueX = node.blueRow;
                int blueY = node.blueCol;

                // '#'이 아닐때까지 구슬을 굴린다.
                while(map[blueX + dir[k][0]][blueY+ dir[k][1]] != '#'){
                    // 현재위치에서 갱tls
                    blueX += dir[k][0];
                    blueY += dir[k][1];
                    // 파란색 구슬이 구멍에 빠질 경우 종료
                    if(map[blueX][blueY] == 'O'){
                        break;
                    }
                }

                // 빨간 구슬 굴리기
                int redX = node.redRow;
                int redY = node.redCol;

                while(map[redX + dir[k][0]][redY + dir[k][1]] != '#'){
                    redX += dir[k][0];
                    redY += dir[k][1];
                    if(map[redX][redY] == 'O'){
                        break;
                    }
                }
                // 파란색구슬만 'O'에 빠지면 다음 방향으로 재탐색을 진행한다.
                if(map[blueX][blueY] == 'O'){
                    continue;
                }
                // 빨간색구슬만 'O'
                if(map[redX][redY] == 'O'){
                    System.out.println(node.actionsSize + 1);
                    return;
                }

                // 위치가 같은 경우 값을 조정한다.
                if(redX == blueX && redY == blueY){
                    // 동쪽으로 기운 경우
                    if(k == 0){
                        if(node.redCol > node.blueCol) blueY-=1;
                        else redY-=1;
                    }
                    // 서쪽으로 기운 경우
                    else if(k == 1){
                        if(node.redCol > node.blueCol) redY+=1;
                        else blueY+=1;
                    }
                    // 남쪽으로 기운 경우
                    else if(k == 2){
                        if(node.redRow > node.blueRow) blueX-=1;
                        else redX-=1;
                    }
                    // 북쪽으로 기운 경우
                    else {
                        if(node.redRow > node.blueRow) redX +=1;
                        else blueX +=1;
                    }
                }
                // 두 구슬을 굴린 후의 각각의 위치가 처음 탐색하는것이라면 큐에 넣는다.
                if(!isChecked[redX][redY][blueX][blueY]) {
                    isChecked[redX][redY][blueX][blueY]= true;
                    q.add(new Node(redX, redY, blueX, blueY, node.actionsSize + 1));
                }
            }
        }
        System.out.println(-1);
        
    }

    private static class Node {
        int redRow;
        int redCol;
        int blueRow;
        int blueCol;
        int actionsSize;

        public Node(int redRow, int redCol, int blueRow, int blueCol, int actionsSize) {
            this.redRow = redRow;
            this.redCol = redCol;
            this.blueRow = blueRow;
            this.blueCol = blueCol;
            this.actionsSize = actionsSize;
        }

        public Node() {
            
        }
    }
}
