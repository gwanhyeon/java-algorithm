import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GameAddiction {
    static int[][] dir = {{-1,0},{0,1},{1,0},{-1,0}};
    static int[][] map;
    static int[][] check;
    static int len = 31;
    static int h;
    static int n;
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        check = new int[len][len];
        map = new int[len][len];
        h = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(j > i){
                    map[i][j] = -1;
                }
            }
        }



        map[h][h] = 1;

        for(int i=h; i<h-n; i++){
            for(int j=h; j<h-n; j++){
                if(map[i][j] == -1){
                    map[i][j] = 0;
                    continue;
                }

                if(i != 0 ){
                    map[i][j] += map[i-1][j];

                }
                if(j != 0){
                    map[i][j] += map[i][j-1];
                }
                if(i != len-1){
                    map[i][j] += map[i+1][j];
                }
                if(j != len-1){
                    map[i][j] += map[i][j+1];
                }
            }
        }
        System.out.println(map[n-1][n-1]);




//
//
//        for(int i=0; i<len; i++){
//            for(int j=0; j<len; j++){
//                if(i < j){
//                    map[i][j] = 1;
//                }
//            }
//        }

//        bfs(h,h,n,n);
//        System.out.println(answer);

    }

//    private static void bfs( int x, int y,int target_x, int target_y) {
//
//        Queue<Pair> q = new LinkedList<>();
//        q.add(new Pair(x,y));
//        check[x][y] = 1;
//
//        while(!q.isEmpty()){
//            Pair pair = q.remove();
//            int dx = pair.x;
//            int dy = pair.y;
//            //System.out.println("dx:"+dx+"dy"+dy);
//
//
//            for(int i=0; i<4; i++){
//                int mx = dx + dir[i][0];
//                int my = dy + dir[i][1];
//                //System.out.println("mx:"+mx+"my"+my);
//                if(mx >= 0 && mx < len && my >= 0 && my < len){
//                    if(map[mx][my] == 0 && check[mx][my] == 0){
//                        check[mx][my] = 1;
//                        q.add(new Pair(mx,my));
//                        if(mx == target_x && my == target_y){
//                            System.out.println("mx:"+mx+"my"+my);
//                            answer++;
//                            check[dx][dy]= 0;
//                            break;
//                        }
//                    }
//
//                }
//            }
//
//
//
//        }
//
//
//
//
//
//    }
//    static class Pair{
//        int x;
//        int y;
//
//        public Pair(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

}
