package 알고리즘유형별.Graph;

class AdjGraph{
    private int[][] arrGraph;


    // 1. 그래프 생성
    public AdjGraph(int graphSize) {
        this.arrGraph = new int[graphSize+1][graphSize+1];
    }

    // 2. 그래프 반환
    public int[][] getGraph(){
        return this.arrGraph;
    }
    // 3. 그래프 양방향 추가
    public void put(int x, int y){
        arrGraph[x][y] = arrGraph[y][x] = 1;
    }

    // 4. 그래프 단방향
    public void putSingle(int x,int y){
        arrGraph[x][y] = 1;
    }

    // 5.그래프 출력
    public void printGraph(){
        for(int i=0; i<arrGraph.length; i++){
            for(int j=0; j<arrGraph[i].length; j++){
                System.out.print("" + arrGraph[i][j]);
            }
            System.out.println();
        }
    }








}
public class AdjArray {
    public AdjArray(int graphSize) {
    }

    public static void main(String[] args) {
        int graphSize = 10;
        AdjGraph adjArr = new AdjGraph(graphSize);

        adjArr.put(1, 2);
        adjArr.put(1, 3);
        adjArr.put(2, 3);
        adjArr.put(2, 4);
        adjArr.put(3, 4);
        adjArr.put(3, 5);
        adjArr.put(4, 5);
        adjArr.put(4, 6);


        adjArr.printGraph();




    }
}
