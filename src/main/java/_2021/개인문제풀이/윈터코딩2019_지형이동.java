import java.util.HashMap;

public class 윈터코딩2019_지형이동 {
    public static void main(String[] args) {
        //solution(new int[][]{{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}},3);
        HashMap<String,String> hs = new HashMap<>();
        hs.put("1", "2");
        hs.put("1", "3");

        hs.forEach((key, value) ->{
            System.out.println(key + "" + value);
        });
    }
    static int[][] dir = {{1,0},{0,-1},{-1,0},{0,1}};
    static int answer = 0;
    static int[][] check;
    static public int solution(int[][] land, int height) {
        check = new int[300][300];
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[i].length; j++){
                // 한개의 점을 기준으로 4방향을 돈다
                go(i,j,land,height);
            }
        }
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land.length; j++){
                if(check[i][j] != 0){
                    System.out.println(check[i][j]);
                }
            }
        }
        return answer;
    }

    private static void go(int x,int y, int[][] land,int height) {
        int min = 10001;
        for(int k=0; k<4; k++){
            int mx = x + dir[k][0];
            int my = y + dir[k][1];
            if(mx >= 0 && mx < land.length && my >= 0 && my < land.length) {
                // 값이 더 클 경우
                if (land[x][y] > land[mx][my]) {
                    // 이동 가능
                    if (land[x][y] - land[mx][my] <= height) {
                        check[x][y] = land[x][y] - land[mx][my];
                        continue;
                    }
                    // 이동 불가능 - 사다리 놓기
                    else {

                        if(check[x][y] != 0 && land[x][y] - land[mx][my] <= check[x][y]){
                            check[x][y] = land[x][y] - land[mx][my];
                        }

                        //min = 유형별.Math.min(min, land[x][y] - land[mx][my]);
                    }
                }
                // 값이 더 작을 경우
                else {
                    // 이동 가능
                    if (land[mx][my] - land[x][y] <= height) {
                        check[x][y] = land[mx][my] - land[x][y];
                        continue;
                    }
                    // 이동 불가능
                    else {
                        if(check[x][y] != 0 && land[mx][my] - land[x][y] <= check[x][y]){
                            check[x][y] = land[mx][my] - land[x][y];
                        }


                    }
                }
            }
        }

    }

}
