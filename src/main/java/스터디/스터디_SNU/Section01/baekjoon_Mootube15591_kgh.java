/*
풀이시간: 초과...
https://travelbeeee.tistory.com/458
 */

package 스터디.스터디_SNU.Section01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
// https://www.acmicpc.net/problem/15591
/**
 * 1. 문제풀이 시간: 30분(복습시)
 * 2. 컴퓨팅사고
 * K값은 유사도를 뜻하고 K값이상으로 연결된 노드만 동영상을 추천시킬 수 있습니다.
 * 가장 먼저 인접리스트를 생성시켜서 모든 값들을 넣어주고 (유사도, 출발시작 노드)
 * 의 값을 바탕으로 BFS를 진행해줍니다. 모든 경우에 대해서 매번 다르게 수행해야하므로 check를 모두 초기화시키면서 진행합니다.
 * 인접리스트 즉, 해당노드에서 시작되는 노드와 연결된 값을 모두 찾아줍니다. 그리고 유사도값 이상인 가중치값을 가진 값들을 찾아주면 됩니다.
 * check변수로 해당 노드를 방문했는지를 체크해주고 해당 인접리스트에 가지고 있는 value의 값이 k이상일때만 다음 노드를 방문할 수 있게 해줍니다.
 * 그때 마다 answer의 값을 카운팅 시켜주면 동영상 추천이 가능한 노드의 개수를 구할 수 있게 됩니다.
 * 결론적으로 인접리스트와 BFS를 활용한 문제였으며 문제가 길고 복잡해보였지만 생각을 조금만 달리한다면 쉽게 풀 수 있던 문제였습니다.
 */
public class baekjoon_Mootube15591_kgh {
    static int n;
    static int q;
    static boolean[] check;
    static int answer = 0;
    static List<List<Pair>> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        initListNode();
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr.get(x).add(new Pair(y,value));
            arr.get(y).add(new Pair(x,value));
        }

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bfs(k, v);          // k이상의 유사도, 시작노드
            System.out.println(answer);
            answer=0;
        }
    }

    private static void initListNode() {
        IntStream.rangeClosed(0, n).forEach(i -> arr.add(new ArrayList<>()));
    }
    private static void bfs(int k, int v) {
        check = new boolean[5001];
        Queue<Integer> q = new LinkedList<>();
        check[v] = true;
        q.add(v);

        while(!q.isEmpty()) {
            int node = q.remove();
            // 연결된 노드에 있는것들을 모두 가져와서 체크
            for (int i = 0; i < arr.get(node).size(); i++) {
                int y = arr.get(node).get(i).y;
                int value = arr.get(node).get(i).value;
                // 방문하지 않은 노드이고, 가중치값이 k보다 크거나 같을 경우만 진행한다. 그 외의 경우에는 진행하지 않는다. 조건을 만족 X
                if (!check[y] && value >= k) {
                    q.add(y);
                    check[y] = true;
                    answer++;
                }
            }
        }
    }
    static class Pair{
        int y;
        int value;
        public Pair(int y, int value) {
            this.y = y;
            this.value = value;
        }
    }
}
