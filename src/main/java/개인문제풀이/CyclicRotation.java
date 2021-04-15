

public class CyclicRotation {
    public static void main(String[] args) {

        int K = 4;
        int A[] = {1,2,3,4};

        K = K % A.length;
        int[] map = new int[A.length];

        for(int i=0; i<A.length-K; i++){
            map[i + K] = A[i];
        }
        for(int i=0; i<K; i++){
            map[i] = A[A.length-K+i];
        }



//        int K = 4;
//        int A[] = {1,2,3,4};
        /*
        int K = 3;
        int A[] = {-9,0};
        유형별.String str = "";
        for(int i=0; i<A.length; i++){
            str += Integer.toString(A[i]);
        }
        유형별.String first = "";
        유형별.String end = "";

        if(str.length() == K){
            end = str.substring(0, K);
        }else {
            first = str.substring(K-1, str.length());
            end = str.substring(0, K-1);
        }


        int[] answer = new int[A.length];
        int idx = 0;
        for(int i=0; i<first.length(); i++){
            answer[i] = Integer.parseInt(유형별.String.valueOf(first.charAt(i)));
            idx++;
        }
        for(int i=0; i<end.length(); i++){
            answer[idx++] =  Integer.parseInt(유형별.String.valueOf(end.charAt(i)));
        }

        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }



        */
//
//
//        Stack<Integer> s = new Stack<>();
//        ArrayList<Integer> front_s = new ArrayList<>();
//        ArrayList<Integer> back_s = new ArrayList<>();
//        ArrayList<Integer> ans = new ArrayList<>();
//
//
//        s.add(3);
//        s.add(8);
//        s.add(9);
//        s.add(7);
//        s.add(6);
//
//        for(int i=0; i<K; i++){
//            front_s.add(s.peek());
//            s.pop();
//        }
//
//        Collections.reverse(front_s);
//
//        while(!s.empty()){
//            back_s.add(s.pop());
//            s.pop();
//        }
//
//        Collections.reverse(back_s);
//
//        ArrayList<Integer> res = new ArrayList<Integer>();
//        for(int i=0; i<front_s.size(); i++){
//            res.add(front_s.get(i));
//        }
//        for(int i=0; i<back_s.size(); i++){
//            res.add(back_s.get(i));
//        }





    }
}
