package _2021.알고리즘유형별.Graph;

import java.util.ArrayList;

class AdjListGraph{
    private ArrayList<ArrayList<Integer>> listGraph;

    public AdjListGraph(int graphSize) {
        this.listGraph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<graphSize+1; i++){
            listGraph.add(new ArrayList<Integer>());
        }
    }

    public ArrayList<ArrayList<Integer>> getGraph(){
        return this.listGraph;
    }

    public ArrayList<Integer> getNode(int i){
        return this.listGraph.get(i);
    }
    public void put(int x,int y,int w){
        listGraph.get(x).add(y);
        listGraph.get(y).add(x);
    }

    public void putSingle(int x,int y, int w){
        listGraph.get(x).add(y);
    }

    public void printGraph(){
        for(int i=0; i<listGraph.size(); i++){
            System.out.print("정점 " + i + "의 인접리스트");
            for(int j=0; j<listGraph.get(i).size(); j++){
                System.out.print(listGraph.get(i).get(j));
            }
            System.out.println();
        }
    }

}
public class AdjList {



    public static void main(String[] args) {
        int graphSize = 10;
        AdjListGraph adjList = new AdjListGraph(graphSize);

        adjList.put(1, 2,1);
        adjList.put(1, 3,1);
        adjList.put(2, 3,1);
        adjList.put(2, 4,1);
        adjList.put(3, 4,1);
        adjList.put(3, 5,1);
        adjList.put(4, 5,1);
        adjList.put(4, 6,1);
        adjList.printGraph();

    }
}
