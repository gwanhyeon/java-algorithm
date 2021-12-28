package _2022.sample;

public class sample {
    /*static List<List<Integer>> graphList;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        graphList = new ArrayList<>();
        distance = new int[n+1];

        for(int i=0; i<=n; i++){
            graphList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graphList.get(x).add(y);
            graphList.get(y).add(x);
        }

        for(int i=0; i<=n; i++){
            Collections.sort(graphList.get(i));
        }

        dfs(v);
        Arrays.fill(distance, 0);
        System.out.println();
        bfs(v);
    }

    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        distance[v] = 1;
        q.add(v);

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");
            for(int i=0; i<graphList.get(x).size(); i++){
                int y = graphList.get(x).get(i);
                if(distance[y] == 0){
                    distance[y] = 1;
                    q.add(y);
                }
            }
        }
    }

    private static void dfs(int v) {
        distance[v] = 1;
        System.out.print(v + " ");

        for(int i=0; i<graphList.get(v).size(); i++){
            int y = graphList.get(v).get(i);
            if(distance[y] == 0){
                dfs(y);
            }
        }
    }*/
}
