package Samsung.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 순열로 돌리니까 시간초과, 조합으로 돌리니까 통
public class 치킨배달_15686번 {
    static int[][] map;
    static int answer;
    static boolean[] isCheck;
    static List<Graph> houseList;
    static List<Graph> chickenList;
    static List<Graph> selectChickenList;
    static int n,m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        answer = Integer.MAX_VALUE;
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();
        selectChickenList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houseList.add(new Graph(i, j));
                } else if (map[i][j] == 2) {
                    chickenList.add(new Graph(i, j));
                }
            }
        }
        isCheck = new boolean[chickenList.size()];
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int cnt, int idx) {

        if(cnt == m){
            // 모든 도시의 치킨집
            int totalChickenPrice = 0;
            for(int i=0; i<houseList.size(); i++) {
                int sum = Integer.MAX_VALUE;
                Graph houseGraph = houseList.get(i);
                for (int j = 0; j < selectChickenList.size(); j++) {
                    Graph chickenGraph = selectChickenList.get(j);
                    sum = Math.min(sum,Math.abs(houseGraph.x - chickenGraph.x) + Math.abs(houseGraph.y - chickenGraph.y));
                }
                totalChickenPrice += sum;
            }
            answer = Math.min(answer, totalChickenPrice);
            return;
        }

        for(int i=idx; i<chickenList.size(); i++){
            if(isCheck[i]) continue;
            isCheck[i] = true;
            selectChickenList.add(new Graph(chickenList.get(i).x, chickenList.get(i).y));
            dfs(cnt+1,i);
            selectChickenList.remove(selectChickenList.size()-1);
            isCheck[i] = false;
        }
    }

    private static class Graph {
        int x;
        int y;

        public Graph(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
