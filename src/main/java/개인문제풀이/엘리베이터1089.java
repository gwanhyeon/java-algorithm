import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 엘리베이터1089 {

    static char[][] map;
    static char[][] map_copy;
    static boolean[][] check;
    static int[][] dir = {{1,0},{0,1},{-1,0},{-1,0}};
    static char[][] one = {
            {'.','.','#'},
            {'.','.','#'},
            {'.','.','#'},
            {'.','.','#'},
            {'.','.','#'}
    };
    static char[][] two = {
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'},
            {'#','.','.'},
            {'#','#','#'}
    };
    static char[][] three = {
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'}
    };
    static char[][] four = {
            {'#','.','#'},
            {'#','.','#'},
            {'#','#','#'},
            {'.','.','#'},
            {'.','.','#'}
    };
    static char[][] five = {
            {'#','#','#'},
            {'#','.','.'},
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'}
    };
    static char[][] six = {
            {'#','#','#'},
            {'#','.','.'},
            {'#','#','#'},
            {'#','.','#'},
            {'#','#','#'}
    };
    static char[][] seven = {
            {'#','#','#'},
            {'.','.','#'},
            {'.','.','#'},
            {'.','.','#'},
            {'.','.','#'}
    };
    static char[][] eight = {
            {'#','#','#'},
            {'#','.','#'},
            {'#','#','#'},
            {'#','.','#'},
            {'#','#','#'}
    };
    static char[][] nine = {
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'},
            {'.','.','#'},
            {'#','#','#'}
    };



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[5][n*3+1];
        map_copy = new char[5][n*3+1];
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3*n+1; j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        map_copy = Arrays.copyOf(map, map.length);
        check = new boolean[5][n*3+1];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(j % 4 == 0 && map[i][j] == '.'){
                    continue;
                }
                if(map[i][j] == '.'){
                    bfs(i,j);
                }



            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        check[x][y] = true;

        while(!q.isEmpty()){
            Pair pair = q.remove();
            int dx = pair.x;
            int dy = pair.y;

            for(int i=0; i<4; i++){
                int mx = dx + dir[i][0];
                int my = dy + dir[i][1];
                //if(mx >= 0 && (mx%4) != 0 && my >= 0 && my % 5){
//                    if(findSegment(mx,my)){
//
//                    }
                //}

            }

        }
    }


    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
