import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        HashMap<Integer,Node> song_info = new HashMap<>();
        HashMap<String, Integer> song_plays_info = new HashMap<>();

        // idx : (genre,plays)
        for(int i=0; i<genres.length; i++){
            if(!song_plays_info.containsKey(genres[i])){
                song_plays_info.put(genres[i], plays[i]);
            }else {
                int tmp = song_plays_info.get(genres[i]);
                song_plays_info.put(genres[i], tmp+plays[i]);
            }
            song_info.put(i, new Node(genres[i], plays[i]));
        }
        List<String> keySetList = new ArrayList<>(song_plays_info.keySet());
        //Collections.sort(keySetList, (o1, o2) -> (song_plays_info.get(o2).compareTo(song_plays_info.get(o1))));
        Collections.sort(keySetList, Collections.reverseOrder());

        ArrayList<Integer> answer = new ArrayList<>();

//        song_plays_info.forEach((k,v)->{
//            System.out.println(v);
//        });
        for(String key : keySetList){
            HashMap<Integer, Integer> res = new HashMap<>();
            int i=0;

            AtomicInteger num = new AtomicInteger();
            for (Map.Entry<Integer, Node> entry : song_info.entrySet()) {
                Integer integer = entry.getKey();
                Node Node = entry.getValue();
                if (i == 0) {
                    num.set(Node.genreNumber);
                    continue;
                }
                //System.out.println(k);
                // 장르와 키값이 같은 경우
                if (Node.genre.equals(key)) {
                    if (num.get() == Node.genreNumber) {

                    }else {
                        res.put(integer, Node.genreNumber);
                    }

                }
            }
            List<Integer> keySetList1 = new ArrayList<>(res.keySet());
            Collections.sort(keySetList1, (o1, o2) -> (res.get(o2).compareTo(res.get(o1))));
            for(Integer k : keySetList1) {
                answer.add(k);
                System.out.println(String.format("Key : %s, Value : %s", k, res.get(k)));
            }
        }
        if(answer.size() % 2 == 0){
            answer.forEach((v) ->{
                System.out.println(v);
            });
        }else {
            answer.remove(answer.size()-1);
            answer.forEach((v) -> {
                System.out.println(v);
            });
        }
    }

    private static class Node {
        String genre;
        int genreNumber;

        public Node(String genre, int genreNumber) {
            this.genre = genre;
            this.genreNumber = genreNumber;
        }
    }
}

//
//        for(int i=0; i<genres.length; i++){
//            // plays_map에 포함이 안되어
//            if(!plays_map.containsKey(genres[i])){
//                plays_map.put(genres[i], plays[i]);
//                plays_part_map.put(genres[i],new Node(i, plays[i]));
//            }else {
//                int tmp = plays_map.get(genres[i]);
//                plays_map.put(genres[i], tmp+plays[i]);
//                plays_part_map.put(genres[i],new Node(i, plays[i]));
//            }
//        }
//    }
//
//    private static class Node {
//        int index;
//        int play_size;
//
//        public Node(int index, int play_size) {
//            this.index = index;
//            this.play_size = play_size;
//        }
//    }
//}
