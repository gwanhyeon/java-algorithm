package _2021.개인문제풀이;

public class 단어변환 {
    static int answer = 0;
    static boolean[] check;
    static void dfs(String begin, String target, String[] words, int cnt) {

        if(target.equals(begin) && words.length > cnt) {
            answer = cnt;
            return;
        }
        for(int i=0; i<words.length; i++){
            int count = 0;
            if(check[i]){
                continue;
            }

            for(int j=0; j<words[j].length(); j++){
                if(begin.charAt(j) != words[i].charAt(j)){
                    count++;
                }
            }

            if(count == 1){
                check[i] = true;
                dfs(words[i], target, words, cnt+1);
                check[i] = false;
            }
        }


    }
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        answer = words.length+1;
        check = new boolean[words.length+1];


        String begin = "hit";
        String target = "cog";
        dfs(begin, target, words,0);
        if(answer == words.length+1){
            return;
        }
        System.out.println(answer);
    }


}
