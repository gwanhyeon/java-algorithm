package _2024.baekjoon;
import java.io.*;
import java.util.*;
public class softeer_금고털이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int totalWeight = Integer.parseInt(st.nextToken());
        int totalKinds = Integer.parseInt(st.nextToken());

        List<Bag> bags = new ArrayList<>();
        for(int i=0; i<totalKinds; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int currWeight = Integer.parseInt(st.nextToken());
            int currPrice = Integer.parseInt(st.nextToken());
            bags.add(new Bag(currWeight, currPrice));
        }
        Collections.sort(bags);

        int answer = 0;
        for(int i=0; i<bags.size(); i++){
            Bag bag = bags.get(i);

            if(totalWeight > bag.w){
                answer += (bag.w) * (bag.p);
                totalWeight -= (bag.w);
            }else {
                answer += (totalWeight * bag.p);
                break;
            }
        }
        System.out.println(answer);
    }
    static class Bag implements Comparable<Bag>{
        int w;
        int p;
        public Bag(){

        }
        public Bag(int w, int p){
            this.w = w;
            this.p = p;
        }

        @Override
        public int compareTo(Bag o1){
            return o1.p - this.p;
        }
    }
}
