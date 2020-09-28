import java.util.*;

public class CyclicRotation {
    public static void main(String[] args) {
        int K = 3;
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> front_s = new ArrayList<>();
        ArrayList<Integer> back_s = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();


        s.add(3);
        s.add(8);
        s.add(9);
        s.add(7);
        s.add(6);

        for(int i=0; i<K; i++){
            front_s.add(s.peek());
            s.pop();
        }

        Collections.reverse(front_s);

        while(!s.empty()){
            back_s.add(s.pop());
            s.pop();
        }

        Collections.reverse(back_s);

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0; i<front_s.size(); i++){
            res.add(front_s.get(i));
        }
        for(int i=0; i<back_s.size(); i++){
            res.add(back_s.get(i));
        }





    }
}
