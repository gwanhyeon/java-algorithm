import java.util.Collections;
import java.util.HashMap;

public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};


        HashMap<String,Integer> plays_map = new HashMap<String,Integer>();
        HashMap<String,Node> plays_part_map = new HashMap<String,Node>();


        for(int i=0; i<genres.length; i++){
            // plays_map에 포함이 안되어
            if(!plays_map.containsKey(genres[i])){
                plays_map.put(genres[i], plays[i]);
                plays_part_map.put(genres[i],new Node(i, plays[i]));
            }else {
                int tmp = plays_map.get(genres[i]);
                plays_map.put(genres[i], tmp+plays[i]);
                plays_part_map.put(genres[i],new Node(i, plays[i]));
            }
        }
    }

    private static class Node {
        int index;
        int play_size;

        public Node(int index, int play_size) {
            this.index = index;
            this.play_size = play_size;
        }
    }
}
