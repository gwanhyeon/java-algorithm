package Samsung.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 주사위굴리기_14499번 {
    static int n,m,x,y,k;
    static int[][] map;
    static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};       // 동서북
    static List<Integer> commandList;
    static int upCopy;      // 1
    static int topCopy;     // 2
    static int rightCopy;   // 3
    static int leftCopy;    // 4
    static int bottomCopy;  // 5
    static int downCopy;    // 6

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        commandList = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            commandList.add(Integer.parseInt(st.nextToken()));
        }
        // 현재 주사위 상태 객체
        Dice dice = new Dice(x,y,0,0,0,0,0,0);

        // 명령어 대로 주사위를 돌린다.
        for (int i = 0; i < commandList.size(); i++) {
            int dx = dice.currX;
            int dy = dice.currY;
            // 현재 주사위 방향
            int currDir = commandList.get(i)-1;
            int mx = dx + dir[currDir][0];
            int my = dy + dir[currDir][1];

            // 주사위 이동방향 체크하기
            if(isCheckRange(mx,my)) continue;
            diceStateSave(dice);
            rollDice(dice, currDir);

            // 지도가 0일 경우
            if(map[mx][my] == 0){
                map[mx][my] = dice.down;
            }
            // 지도가 0이 아닐 경우
            else {
                dice.down = map[mx][my];
                map[mx][my] = 0;
            }
            System.out.println(dice.up);
            dice.currX = mx;
            dice.currY = my;
        }
    }

    private static void rollDice(Dice dice, int currDir) {
        if(currDir == 0){
            dice.right = upCopy;
            dice.down = rightCopy;
            dice.left = downCopy;
            dice.up = leftCopy;
        }else if(currDir == 1){
            dice.left = upCopy;
            dice.down = leftCopy;
            dice.right = downCopy;
            dice.up = rightCopy;
        }else if(currDir == 2){
            dice.top = upCopy;
            dice.down = topCopy;
            dice.bottom = downCopy;
            dice.up = bottomCopy;
        }else if(currDir == 3){
            dice.up = topCopy;
            dice.bottom = upCopy;
            dice.down = bottomCopy;
            dice.top = downCopy;
        }
    }

    private static void diceStateSave(Dice dice) {
        upCopy = dice.up;
        topCopy = dice.top;
        rightCopy = dice.right;
        leftCopy = dice.left;
        bottomCopy = dice.bottom;
        downCopy = dice.down;
    }

    private static boolean isCheckRange(int mx, int my) {
        if(mx < 0 || mx >= n || my < 0 || my >= m) return true;
        return false;
    }
    private static class Dice {
        int currX;
        int currY;

        // 윗면, 아랫면
        int up;      // 1
        int top;     // 2
        int right;   // 3
        int left;    // 4
        int bottom;  // 5
        int down;    // 6

        public Dice(int currX, int currY, int up, int top, int right, int left, int bottom, int down) {
            this.currX = currX;
            this.currY = currY;
            this.up = up;
            this.top = top;
            this.right = right;
            this.left = left;
            this.bottom = bottom;
            this.down = down;
        }
    }
}
