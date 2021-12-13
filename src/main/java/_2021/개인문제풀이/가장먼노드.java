import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6},{4, 3},{3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        boolean[][] map = new boolean[n+1][n+1];
        int[] check = new int[n+1];
        for(int i=0; i<edge.length; i++){
            map[edge[i][0]][edge[i][1]] =map[edge[i][1]][edge[i][0]] = true;
            //map[edge[i][0]][edge[i][1]] =map[edge[i][1]][edge[i][0]] = 1;         //왜 boolean 으로 처리해야하나 에러난다
        }

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);

        int max = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.println("node=>" + node);

            for(int i=2; i<=n; i++){
                if(check[i] == 0 && map[node][i]){
                    check[i] = check[node] + 1;
                    q.add(i);
                    System.out.println("dist=>" + check[i]);
                    max = Math.max(max, check[i]);
                }
            }
        }
        int cnt = 0;
        for(int value : check){
            if(max == value){
                cnt++;
            }
        }

//        System.out.println(cnt);
    }
}
