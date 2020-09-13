import java.util.ArrayList;
import java.util.HashMap;

public class kakao_test03 {
    static class Pair{
        String lang;
        String position;
        String career;
        String food;
        String score;

        public Pair(String lang, String position, String career, String food, String score) {
            this.lang = lang;
            this.position = position;
            this.career = career;
            this.food = food;
            this.score = score;
        }
    }
    public static void main(String[] args) {

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        ArrayList<Pair> list = new ArrayList<Pair>();
        HashMap<String,String> map = new HashMap<String,String>();


        for (String info_value: info) {
            String[] split_info = info_value.split(" ");
            list.add(new Pair(split_info[0],split_info[1],split_info[2],split_info[3],split_info[4]));
        }
        int answer[] = new int[query.length];
        int idx = 0;
        int r = 0;
        String[] split_query = new String[query.length+1];
        String tmp = "";
//        for(String query_value : query) {
//             query_value = query_value.replaceAll(" and ", "");
//             tmp += query_value.split(" ");
//             for(String a : split_query){
//
//             }
//        }




            for (int j = 0; j < query.length; j++) {
                split_query = new String[query.length + 1];
                query[j] = query[j].replaceAll(" and", "");
                split_query = query[j].split(" ");
                int cnt = 0;
                for(int i=0; i<list.size(); i++) {
                    Pair pair = list.get(i);

                    for (String s : split_query) {
                        if (s.equals("-")) {
                            cnt++;
                        }
                        if (pair.lang.contains(s)) {
                            cnt++;
                        }
                        if (pair.position.contains(s)) {
                            cnt++;
                        }
                        if (pair.career.contains(s)) {
                            cnt++;
                        }
                        if (pair.food.contains(s)) {
                            cnt++;
                        }
                        if (pair.score.contains(s)) {
                            cnt++;
                        }
                        if (cnt == 5) {
                            answer[idx] += 1;
                            idx++;
                        }
                    }
                    cnt = 0;
                }
            }


//            for(int j=0; j<query.length; j++){
//
//
//                Pair pair = list.get(i);
//                if(split_query[j].equals("-")){
//                    cnt++;
//                    continue;
//                }
//                if(pair.lang.contains(split_query[j])){
//                    cnt++;
//                }
//                if(pair.position.contains(split_query[j])){
//                    cnt++;
//                }
//                if(pair.career.contains(split_query[j])){
//                    cnt++;
//                }
//                if(pair.food.contains(split_query[j])){
//                    cnt++;
//                }
//                if(pair.score.contains(split_query[j])){
//                    cnt++;
//                }
//
//            }
//            if(cnt == 5){
//                answer[idx]+=1;
//            }
//            cnt = 0;
//            idx++;


//        for(int i=0; i<split_query.length; i++){
//
//
//
//            for(int j=0; j<list.size(); j++) {
//                if(split_query[i].equals("-")){
//                    cnt++;
//                }
//
//                Pair pair = list.get(j);
//                if (i == 0) {
//                    if(pair.lang.contains(split_query[i])){
//                        cnt++;
//                    }
//                }
//                if (i == 1) {
//                    if(pair.position.contains(split_query[i])){
//                        cnt++;
//                    }
//                }
//                if (i == 2) {
//                    if(pair.career.contains(split_query[i])){
//                        cnt++;
//                    }
//                }if (i == 3) {
//                    if(pair.food.contains(split_query[i])){
//                        cnt++;
//                    }
//                }
//                if (i == 4) {
//                    if(pair.score.contains(split_query[i])){
//                        cnt++;
//                    }
//                }
//                if(cnt == 5){
//                    answer[idx]+=1;
//                }
//            }
//            idx++;
//            cnt =0;
//
//
//        }
        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }







    }
}

/*

코딩테스트에 java로 참여했으며, backend 직군을 선택했고, junior 경력이면서, 소울푸드로 pizza를 선택한 사람 중 코딩테스트 점수를 50점 이상 받은 지원자는 몇 명인가?

 */